package hard._315;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/23.
 */
public class test {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> temp = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = helper(nums[i], temp);
        }
        temp.clear();
        for (int i = 0; i < n; i++) {
            temp.add(ans[i]);
        }
        return temp;
    }

    private int helper(int num, List<Integer> temp) {
        int left = 0;
        int right = temp.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (temp.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        temp.add(left, num);
        return left;
    }
}
