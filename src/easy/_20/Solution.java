package easy._20;

import java.util.Stack;

/**
 * Created by Citrix on 2018/8/16.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()){
            if ( c == '('){
                stack.push(')');
            }
            else if (c == '{'){
                stack.push('}');
            }
            else if (c == '['){
                stack.push(']');
            }
            else{
                if (stack.isEmpty() == true || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
