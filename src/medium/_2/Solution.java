package medium._2;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/25.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        int temp = 0;
        while(l1 != null || l2 != null || temp != 0){

            if (l1!=null){
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                temp += l2.val;
                l2 = l2.next;
            }
            ListNode tempnode = new ListNode(temp%10);
            point.next = tempnode;
            point = point.next;
            temp = temp/10;
        }
        return result.next;
    }
}
