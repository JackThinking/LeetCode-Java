package medium._1004;

/**
 * Created by Citrix on 2019-04-28.
 */
public class Solution {
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int right;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                K--;
            }
            if (K < 0 && A[left++] == 0) {//这个地方很有讲究，必须是当不够了，left边界必须
                K++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(test, 3));
    }
}
