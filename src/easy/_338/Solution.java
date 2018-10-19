package easy._338;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/19.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }
}
