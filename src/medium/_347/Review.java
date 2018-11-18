package medium._347;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * Created by Citrix on 2018/11/18.
 */
public class Review {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> keyset : map.entrySet()) {
            pq.offer(keyset);
        }
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
}
