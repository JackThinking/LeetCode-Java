package medium._438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/11/6.
 */
public class test {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int lens = s.length();
        int lenp = p.length();
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < lenp; i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        if (isValid(map)) {
            res.add(0);
        }
        for (int i = lenp; i < lens; i++) {
            map[s.charAt(i) - 'a']--;
            map[s.charAt(i - lenp) - 'a']++;
            if (isValid(map)) {
                res.add(i - lenp + 1);
            }
        }
        return res;
    }

    private boolean isValid(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
