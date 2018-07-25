package medium._347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Citrix on 2018/7/24.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> table = new HashMap<>();
        List<Integer>[] bukcet = new List[nums.length+1];
        for(int n: nums){
            table.put(n,table.getOrDefault(n,0)+1);
        }
        for(int key: table.keySet()){
            int fqc = table.get(key);
            if (bukcet[fqc] == null){
                bukcet[fqc] = new ArrayList<>();
            }
            bukcet[fqc].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size()<k; i--) {
           if (bukcet[i]!=null){
               res.addAll(bukcet[i]);
           }

        }
        return res;
    }
}
