package medium._451;

import java.util.*;

/**
 * Created by Citrix on 2019-04-10.
 */
public class Solution {
    public String frequencySort_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(map.get(c), 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
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

    public String frequencySort_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(map.get(c), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
