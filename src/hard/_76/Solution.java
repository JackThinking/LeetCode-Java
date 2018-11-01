package hard._76;

/**
 * Created by Citrix on 2018/10/28.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int count = t.length();
        int[] dict = new int[256];
        for (char c : t.toCharArray()) {
            dict[c]++;
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        char[] array = s.toCharArray();
        for (; i < s.length(); i++) {
            /*
             * 这个while条件没有写出来，其实就是考虑到范围而已
             * */
            while (count != 0 && j < s.length()) {
                if (dict[array[j]] > 0) {
                    count--;
                }
                dict[array[j]]--;
                j++;
            }
            /*
             * 这边的判断条件也失误了
             * */
            if (count == 0 && j - i < minLen) {
                minLen = j - i;
                start = i;
            }
            /*
             * 这里的细节还是不清楚，这个算法好就在count的技术和dict里面的数字是分开的，要是s有t多余的字符是不会造成影响的，因为在前面就被设置成负数了
             * */
            if (dict[array[i]] == 0) {
                count++;
            }
            dict[array[i]]++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
