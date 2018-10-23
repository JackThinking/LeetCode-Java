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
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            {
                /*
                 * 去尾工作，删掉之前的
                 * */
                while (!q.isEmpty() && q.peek() < i - k + 1) {
                    q.poll();
                }
                /*
                 * 去掉比新来的还小的数
                 * */
                while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.pollLast();
                }

                q.offer(i);
                if (i >= k - 1) {
                    res[index++] = nums[q.peek()];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(solution.maxSlidingWindow(nums,  3));
    }
}

