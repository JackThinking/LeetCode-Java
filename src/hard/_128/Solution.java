package hard._128;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2018/10/13.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.maxUnion();
    }

    class UF {
        private int[] id;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        /*
         * id[i] = i 可以理解为建立指向，i = id[i]理解为按指针取值，知道取出来的值等于其本身序号
         * */
        private int root(int i) {
            while (i != id[i]) {
                i = id[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        /*
         * quickunion的含义就是union操作简单
         * */
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            id[i] = j;

        }

        public int maxUnion() {
            int[] count = new int[id.length];
            int max = 0;
            for (int i = 0; i < id.length; i++) {
                count[root(i)]++;
                max = Math.max(max, count[root(i)]);
            }
            return max;
        }
    }
}
