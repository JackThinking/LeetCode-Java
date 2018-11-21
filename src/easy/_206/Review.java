package easy._206;

import structure.ListNode;

/**
 * Created by Citrix on 2018/11/21.
 */
public class Review {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode tempNode = head;
        while (head != null) {
            tempNode = head;
            head = head.next;
            tempNode.next = newNode;
            newNode = tempNode;
        }
        return newNode;
    }
}
