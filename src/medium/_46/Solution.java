package medium._46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/29.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List list = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
