package easy._141;

import structure.ListNode;
/**
 * Created by Citrix on 2018/8/24.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head, fast = head.next;
        while(slow!=null&&fast.next!=null){
            if (fast.next.next == null){
                return false;
            }

            if (slow == fast){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }
}
