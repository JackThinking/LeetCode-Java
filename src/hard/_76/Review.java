package hard._76;

/**
 * Created by Citrix on 2018/11/25.
 */
public class Review {
    public String minWindow(String s, String t) {
        int count = t.length();//这里count和dict双用的本质还是没有理解，count是用来计数的，dict是用来判断的
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int[] dict = new int[256];
        char[] array = new char[s.length()];
        int j = 0;
        for (char c : t.toCharArray()) {
            dict[c]++;
        }
        for (int i = 0; i < s.length(); i++) {

            /*
             * 如果匹配到了pattern中需要的值，count--，dict也要减
             * */
            while (count != 0 && j < s.length()) {//while循环没有想到
                if (dict[array[j]] > 0) {
                    count--;
                }
                dict[array[j]]--;
                j++;
            }
            /*
             * 判断全部匹配到时的len是不是更短
             * */
            if (count == 0 && j - i < minLen) {
                minLen = j - i;
                start = i;
            }
            /*
             * 如果后面又出现了之前dict为0的数，重新给机会
             * */
            if (dict[array[i]] == 0) {
                count++;
            }
            dict[array[i]]++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        System.out.println(solution.minWindow(s1, s2));
    }
}
