package easy._206;


import structure.ListNode;

/**
 * Created by Citrix on 2018/8/22.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        ListNode tempnode = null;
        while(head!= null){
            tempnode = head;
            head = head.next;
            tempnode.next = newhead;
            newhead = tempnode;
        }
        return newhead;
    }
}
