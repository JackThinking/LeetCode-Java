package easy._21;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/23.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode point = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (l1 == null){
            point.next = l2;
        }
        if (l2 == null){
            point.next = l1;
        }
        return result.next;
    }

}
