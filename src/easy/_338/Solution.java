package easy._338;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/19.
 */
public class Solution {
    public int[] countBits(int num) {
        /*int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;*/
        int[] ans = new int[num + 1];
        if (num < 0) {
            return ans;
        }
        ans[0] = 0;
        int shift = 1;
        int begin = 1;
        int end = (1 << shift) - 1;//这里是因为移位比乘法更高效
        while (begin <= num) {
            for (int i = begin; i <= end; i++) {
                if (i > num) {
                    break;
                }
                ans[i] = ans[i - begin] + 1;//这个是我自己想到的动态规划方法，但是自己想歪了，没有做出来，这道题提供了一个同一个2的层级的做法
            }
            shift++;
            begin = end + 1;
            end = (1 << shift) - 1;
        }
        return ans;
    }
}
