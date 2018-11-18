package medium._147;

import structure.ListNode;

/**
 * Created by Citrix on 2018/11/18.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        while (head != null && head.next != null) {
            if (head.val > head.next.val) {
                ListNode insertPosition = dummyNode;
                ListNode insertElement = head.next;
                /*
                * 这边的条件判断不小心呀
                * */
                while (insertPosition.next.val < insertElement.val) {
                    insertPosition = insertPosition.next;
                }
                head.next = insertElement.next;
                insertElement.next = insertPosition.next;
                insertPosition.next = insertElement;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }
}
