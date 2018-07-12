package hard._279;

/**
 * Created by Citrix on 2018/7/12.
 */
public class Solution {
    public int numSquares(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(res[i-j*j]+1,min);
            }
            res[i] = min;
        }
        return res[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
