package hard._76;

import java.util.Map;

/**
 * Created by Citrix on 2018/10/30.
 */
public class test {
    /*
     * 改进思路，真的要用map来存嘛，不能用数组？
     * */
    public String minWindow(String s, String t) {
        int count = t.length();
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;//这句话没有写出
        }
        int i = 0;
        int j = 0;
        int head = 0;//这个才是起始点
        int minLen = Integer.MAX_VALUE;
        char[] array = s.toCharArray();
        for (; i < s.length(); i++) {
            /*
             * 这里没有相出来
             * */
            while (count != 0 && j < array.length) {
                if (map[array[j]] > 0) {
                    count--;
                }
                map[array[j]]--;
                j++;
            }
            /*
             * 刚好t中的数组都出现了，此时进行最小区间判断
             * */
            if (count == 0 && j - i < minLen) {
                minLen = j - i;
                head = i;
            }
            if (map[array[i]] == 0) {
                count++;
            }
            map[array[i]]++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }
}
