package medium._5;

/**
 * Created by Citrix on 2018-12-26.
 */
/*
 * 需要考虑奇偶，考虑到双指针左右滑动，考虑到把函数提前出来，错的是我以为把判断函数提取出来，而不是双指针函数（判断对称我反正是想到双指针）
 * */
public class Solution {
    public int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len-1; i++) {
            helper(s, i, i);//奇数情况
            helper(s, i, i + 1);//偶数情况
        }
        return s.substring(lo, lo + maxLen);
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }
}
