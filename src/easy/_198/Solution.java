package easy._198;

/**
 * Created by Citrix on 2018/7/4.
 */
public class Solution {
    /*
     * 确定其满足dp特征，能用树状图推导其辅助变量的都推导形式
     * */
    //memo放在外面方便递归调用，不要赋值，因为不知道赋多少
    /*int[] memo;
    public int rob(int[] nums) {
        //鲁棒性检测
        if (nums.length == 0) {
            return 0;
        }
        //memo赋初值
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        //考虑递归结构的时候需要考虑到每次变化的基础变量
        return robHelper(nums, 0);
    }

    private int robHelper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        //memo的前哨兵
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 0;
        //可能性扩展遍历，注意其边界
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + robHelper(nums, i + 2));
        }
        //memo的后哨兵
        memo[index] = res;
        return res;
    }*/

    public int rob(int[] nums) {
        /*
         * 搞清楚递归的核心方程式之后，在底层用砖块积累
         * */
        if (nums.length == 0) {
            return 0;
        }
        //memo数组还是要用，不过首先要确定其含义，由于其核心方程是nums[i]+helper(i+2,N-1)，可知其是基于未来的，则要从反向进行递推
        int N = nums.length;
        int[] memo = new int[N];
        for (int i = 0; i < N; i++) {
            memo[i] = -1;
        }
        memo[N - 1] = nums[N - 1];//第一个砖块是确定的，可以是设置0，也可以是实际值
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < N ? memo[j + 2] : 0));//注意i,j的变动范围
            }
        }
        return memo[0];
    }


    /*public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int n : nums) {
            int tmp = curr;
            curr = Math.max(prev + n, curr);
            prev = tmp;
        }
        return curr;
    }*/
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.rob(nums));
    }
}
