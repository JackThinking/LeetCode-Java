package extend;

/**
 * Created by Citrix on 2019-03-03.
 */
public class Knapsack01 {
    /*
     * 自顶向下版本
     * */
    public int[][] memo;

    public int knapsack01_1(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[w.length][C + 1];//这个错误太傻了
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, n - 1, C);
    }

    public int bestValue(int[] w, int[] v, int index, int c) {
        //先判断截止条件
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue(w, v, index - 1, c);//首先会有一个用来比较的初始res值
        if (c >= w[index]) {//这个判断条件可以从递推的式子里看出来
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));//没有价值的累计怎么玩
        }
        memo[index][c] = res;
        return res;
    }

    /*
     * 自底向上版本
     * */
    public int knapsack01_2(int[] w, int[] v, int C) {
        if (w.length != v.length) {
            return -1;
        }
        int n = w.length;
        int[][] memo2 = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i][j] = -1;
            }
        }
        //初始化边界值，想不到的话，从后面的递归式子可以看出
        for (int i = 0; i <= C; i++) {
            memo2[0][i] = i > w[0] ? v[0] : 0;//这个式子的含义没有理解清楚
        }
        //i表示选择的背包，j表示可用容量
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i][j] = memo2[i - 1][j];//相当于最开始的res
                if (j >= w[i]) {//if的式子与下面的递归照相辉映
                    memo2[i][j] = Math.max(memo2[i][j], v[i] + memo2[i - 1][j - w[i]]);
                }
            }
        }
        return memo2[n - 1][C];
    }

    /*
     * 空间初步优化版本，把N行变2行
     * */
    public int knapsack01_3(int[] w, int[] v, int C) {
        if (w.length != v.length) {
            return -1;
        }
        int n = w.length;
        int[][] memo2 = new int[2][C + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i][j] = -1;
            }
        }
        //初始化边界值，想不到的话，从后面的递归式子可以看出
        for (int i = 0; i <= C; i++) {
            memo2[0][i] = i > w[0] ? v[0] : 0;//这个式子的含义没有理解清楚
        }
        //i表示选择的背包，j表示可用容量
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i % 2][j] = memo2[(i - 1) % 2][j];//相当于最开始的res
                if (j >= w[i]) {//if的式子与下面的递归照相辉映
                    memo2[i % 2][j] = Math.max(memo2[i % 2][j], v[i] + memo2[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo2[(n - 1) % 2][C];
    }

    /*
     * 最终空间初步优化版本，把N行变1行，有点难理解
     * */
    public int knapsack01_4(int[] w, int[] v, int C) {
        if (w.length != v.length) {
            return -1;
        }
        int n = w.length;
        int[] memo3 = new int[C + 1];
        for (int i = 0; i <= C; i++) {
            memo3[i] = i > w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                memo3[j] = Math.max(memo3[j], v[i] + memo3[j - w[i]]);
            }
        }
        return memo3[C];
    }

    public static void main(String[] args) {
        int[] value = {6, 10, 12};
        int[] weight = {1, 2, 3};
        Knapsack01 k = new Knapsack01();
        long startTime = System.nanoTime();
        int max = k.knapsack01_4(weight, value, 5);
        long endTime = System.nanoTime();
        System.out.println(max);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }
}
