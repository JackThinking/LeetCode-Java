package medium._300;

/**
 * Created by Citrix on 2019-04-26.
 */
public class Test {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N];
        int size = 0;
        for (int num : nums) {
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num > dp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
