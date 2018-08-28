package medium._328;

import structure.ListNode;


/**
 * Created by Citrix on 2018/8/28.
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        /*ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode po = odd;
        ListNode pe = even;
        while(head!= null && head.next!=null){
            po.next = head;
            po = po.next;
            pe.next = head.next;
            pe = pe.next;
            head = head.next.next;
        }
        even = even.next;
        po.next = even;
        odd = odd.next;
        return odd;*/
        if (head!=null){
            ListNode odd = head, even = head.next, evenhead = even;
            while(even!=null&&even.next!=null){
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenhead;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.oddEvenList(ListNode.createTestData("[1,2,3,4,5,6]")));
    }
}
