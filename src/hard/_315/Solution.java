package hard._315;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/12.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            res[i] = insert(list, nums[i]);
        }
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(res[i]);
        }
        return list;
    }

    private int insert(ArrayList<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) >= num) {
                r = m - 1;
            } else if (list.get(m) < num) {
                l = m + 1;
            }
        }
        list.add(l, num);
        return l;
    }
}
