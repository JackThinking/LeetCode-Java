package medium._147;

import structure.ListNode;

/**
 * Created by Citrix on 2018/11/18.
 */
public class Solution {
    /*
    * 基于链表的插入排序不像书上的那种挨个交换，而是找到插入的位置后，其后面的节点统一往后移动一格
    * */
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
                /*
                * 这道题涉及了链表的断开插入，其中节点链的断开和合并，是从后向前反推的，有点像pre now curr的替换关系，其公式必定是前后交叉的
                * */
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
