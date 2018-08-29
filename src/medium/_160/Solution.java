package medium._160;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/29.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;
        while(pointA!=pointB){
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.getIntersectionNode(ListNode.createTestData("[7,3,4,5]"),ListNode.createTestData("[1,2,3,4,5]")));
    }
}