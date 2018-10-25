package hard._152;

/**
 * Created by Citrix on 2018/10/24.
 */
public class test {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        /*
         * 设计到dp的时候往往要有i-1,更有i-2的情况，这个时候开始点经常为i=1，然后初始值自己设定一个，dp数组的长度也一般长一点
         * */
        int[] maxdp = new int[n + 1];
        int[] mindp = new int[n + 1];
        maxdp[0] = 1;
        mindp[0] = 1;
        for (int i = 1; i <= n; i++) {
            maxdp[i] = Math.max(maxdp[i - 1] * nums[i - 1], Math.max(mindp[i - 1] * nums[i - 1], nums[i - 1]));
            mindp[i] = Math.min(maxdp[i - 1] * nums[i - 1], Math.min(mindp[i - 1] * nums[i - 1], nums[i - 1]));
            max = Math.max(max, maxdp[i]);
        }
        return max;
    }
}
