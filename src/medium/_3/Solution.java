package medium._3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2018-12-24.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;*/
        if (s.length() < 2) {
            return s.length();
        }
        boolean[] dict = new boolean[128];
        char[] arrays = s.toCharArray();
        int start = 0;
        int max = 1;
        dict[arrays[start]] = true;
        for (int i = 1; i < arrays.length; i++) {
            if (dict[arrays[i]]) {
                while (arrays[start] != arrays[i]) {
                    dict[arrays[start]] = false;
                    ++start;
                }
                ++start;
            } else {
                dict[arrays[i]] = true;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String nums = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(nums));
    }
}
