package hard._403;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Citrix on 2018/7/18.
 */
public class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i>3 && stones[i]>2*stones[i-1]){
                return false;
            }
            set.add(stones[i]);
        }

        return canReach(0,0, stones[n-1], set);
    }

    public boolean canReach(int pos, int step, int last, Set<Integer> set) {
        /*if ((pos + step) == last || (pos + step-1) == last ||(pos + step+1) == last){
            return true;
        }*/
        if (pos == last){
            return true;
        }
        for (int i = step+1; i >= step-1 ; i--){
            if (i>0 && set.contains(pos+i) && canReach(pos+i,i,last,set)){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2,3,4,8,9,11};
        System.out.println(solution.canCross(nums));
    }
}
