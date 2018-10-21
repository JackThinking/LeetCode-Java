package medium._394;

import java.util.Stack;

/**
 * Created by Citrix on 2018/10/21.
 */
public class Solution {
    public String decodeString(String s) {
        /*
         * 第二个查看点，找res的定义位置
         * */
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            /*
             * 第一个查看点，如何判断是字符是数字呢
             * */
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                /*
                 * 第三个查看点，忘记加while了
                 * */
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                /*
                 * 第三个查看点，对于stringbuild的理解，对于res值的理解
                 * */
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTime = countStack.pop();
                for (int i = 0; i < repeatTime; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
