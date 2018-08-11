package medium._39;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/8/11.
 */
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(),candidates,0,target);//new出来的不要具体说明的嘛?
        return res;
    }
    private void helper(List<Integer> list, int[] candidates, int start, int remain){
        if (remain == 0){
            res.add(new ArrayList<>(list));//为什么不直接add list呢？
            return;
        }
        else{
            for (int i = start; i < candidates.length; i++) {
                if (remain<candidates[i]){
                    continue;
                }
                list.add(candidates[i]);
                helper(list,candidates,i,remain-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,5};
        System.out.println(solution.combinationSum(nums,8));
    }
}