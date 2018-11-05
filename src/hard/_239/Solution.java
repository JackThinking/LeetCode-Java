package hard._239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Citrix on 2018/10/23.
 */
public class Solution {
    /*
     * 这道题用deque的方法可行，但是写的时候反复用到deque的函数感觉多余了，可以改成数组的形式维护
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int start = 0;
        int end = k - 1;
        int maxIndex = -1;//
        int maxVal = 0;
        while (end < n) {
            if (start > maxIndex) {
                maxIndex = start;
                maxVal = nums[maxIndex];
                for (int i = start; i < end; i++) {
                    if (nums[i] > maxVal) {
                        maxIndex = i;
                        maxVal = nums[maxIndex];
                    }
                }
            }
            res[start++] = maxVal;
            end++;
            if (end == n) {
                break;
            }
            if (nums[end] > maxVal) {
                maxIndex = end;
                maxVal = nums[maxIndex];
            }
        }
        return res;
    }
}

