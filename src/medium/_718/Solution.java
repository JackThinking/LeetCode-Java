package medium._718;

import java.net.DatagramPacket;

/**
 * Created by Citrix on 2018/7/17.
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int n = A.length;
        int m = B.length;
        int dp[] = new int[m+1];
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                if (A[i] == B[j-1]){
                    dp[j] = dp[j-1] +1;
                    max = Math.max(max,dp[j]);
                }
                else{
                    dp[j]  = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(solution.findLength(A,B));
    }
}
