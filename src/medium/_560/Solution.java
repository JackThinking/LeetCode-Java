package medium._560;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2018/10/14.
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        /*int n = nums.length;
        int count = 0;
        int sum[] = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;*/
        /*int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;*/
        /*
        * 有点难理解
        * */
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashmap.containsKey(sum-k)){
                count+= hashmap.get(sum-k);
            }
            hashmap.put(sum, hashmap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
