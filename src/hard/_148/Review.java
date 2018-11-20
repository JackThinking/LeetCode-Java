package hard._148;

import structure.ListNode;

/**
 * Created by Citrix on 2018/11/20.
 */
public class Review {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = head;
        /*
         * 这个相当于是二分啦
         * */
        while (fast != null && fast.next != null) {//有fast的存在，判断的时候需要有两个判断条件
            pre = slow;//这个pre用来切数组，周末一定要把链表的
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
