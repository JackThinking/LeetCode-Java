package medium._438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/18.
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int s_l = s.length();
        int p_l = p.length();
        int[] map = new int[26];
        for (int i = 0; i < p_l; i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        /*
         * 初始化后先判断可以不
         * */
        List<Integer> ans = new ArrayList<>();
        if (isValid(map)) {
            ans.add(0);
        }
        for (int i = p_l; i < s_l; i++) {
            map[s.charAt(i) - 'a']--;
            map[s.charAt(i - p_l) - 'a']++;
            if (isValid(map)) {
                ans.add(i - p_l + 1);
            }
        }
        return ans;
    }
    /*
     * 像这种判断索性直接拉出来写个函数好了
     * */
    private boolean isValid(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = "cbaebabacd";
        String test2 = "abc";
        System.out.println(solution.findAnagrams(test1, test2));
    }
}
