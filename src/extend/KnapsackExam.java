package extend;


import java.util.Arrays;

/**
 * Created by Citrix on 2019-03-04.
 */
public class KnapsackExam {

    int[][] memo;

    public int knapsack01_1(int[] weight, int[] value, int C) {
        if (weight.length == 0 || value.length == 0 || weight.length != value.length) {
            return -1;
        }
        memo = new int[weight.length][C + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(weight, value, C, weight.length - 1);
    }

    private int bestValue(int[] weight, int[] value, int C, int index) {
        if (index <= 0 || C < 0) {
            return 0;
        }
        if (memo[index][C] != -1) {
            return memo[index][C];
        }
        int res = bestValue(weight, value, C, index - 1);
        if (C >= weight[index]) {
            res = Math.max(res, value[index] + bestValue(weight, value, C - weight[index], index - 1));
        }
        memo[index][C] = res;
        return res;
    }

    public int knapsack01_2(int[] w, int[] v, int C) {
        int[][] memo2 = new int[w.length][C + 1];
        int n = w.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i][j] = -1;
            }
        }
        for (int i = 0; i <= C; i++) {
            memo2[0][i] = i>w[0] ? v[0] : 0;//还是不熟练
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo2[i][j] = memo2[i - 1][j];
                if (j >= w[i]) {
                    memo2[i][j] = Math.max(memo2[i][j], v[i] + memo2[i - 1][j - w[i]]);
                }
            }
        }
        return memo2[n - 1][C];
    }


    public static void main(String[] args) {
        int[] value = {6, 10, 12};
        int[] weight = {1, 2, 3};
        KnapsackExam k = new KnapsackExam();
        long startTime = System.nanoTime();
        int max = k.knapsack01_2(weight, value, 5);
        long endTime = System.nanoTime();
        System.out.println(max);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }


}
