package hard._45;

/**
 * Created by Citrix on 2018/7/19.
 */
public class Solution {
    public int jump(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(nums));
    }
}
