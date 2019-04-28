package medium._451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Citrix on 2019-04-10.
 */
public class Test {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];//这个是因为不考虑0的情况，最差从1开始，所以要加1
        for (char c : map.keySet()) {
            int fre = map.get(c);
            if (buckets[fre] == null) {
                buckets[fre] = new ArrayList<>();
            }
            buckets[fre].add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
