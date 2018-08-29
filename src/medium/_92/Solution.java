package medium._92;

import structure.ListNode;


/**
 * Created by Citrix on 2018/8/28.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n-m ; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.reverseBetween(ListNode.createTestData("[1,2,3,4,5]"),2,4));
    }
}
