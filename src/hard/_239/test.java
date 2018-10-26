package hard._239;

/**
 * Created by Citrix on 2018/10/26.
 */
public class test {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{0};
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int start = 0;
        int end = k - 1;
        int maxIndex = -1;
        int maxVal = 0;
        while (end < n) {
            /*
             * 解决前向问题，即最大的数不会被弹出去，这样的话后面的只需要和之前的最大值比较即可
             * */
            if (maxIndex < start) {
                maxIndex = start;
                maxVal = nums[maxIndex];
                for (int i = start; i <= end; i++) {
                    if (nums[i] > maxVal) {
                        maxVal = nums[i];
                        maxIndex = i;
                    }
                }
            }
            res[start++] = maxVal;
            end++;
            if (end == n) {
                break;
            }
            /*
             * 后来的与之前的maxVal比较
             * */
            if (nums[end] > maxVal) {
                maxVal = nums[end];
                maxIndex = end;
            }
        }
        return res;
    }
}
