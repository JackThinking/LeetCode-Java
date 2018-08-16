package easy._682;

import java.util.Stack;

/**
 * Created by Citrix on 2018/8/16.
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for (String c : ops) {
            if (c.equals("+")){
                int temp = s.pop();
                int add = temp+s.peek();
                sum += add;
                s.push(temp);
                s.push(add);

            }
            else if(c.equals("C")){
                int cancel = s.pop();
                sum -= cancel;

            }
            else if(c.equals("D")){
                int db = s.pop();
                int db_2 = db*2;
                sum += db_2;
                s.push(db);
                s.push(db_2);

            }
            else{
                int temp = Integer.parseInt(c);
                sum += temp;
                s.push(temp);
            }
        }
        return sum;
    }

}
