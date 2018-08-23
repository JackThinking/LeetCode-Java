package easy._206;


import structure.ListNode;


/**
 * Created by Citrix on 2018/8/22.
 */
public class Solution {
    /*
    * 迭代法
    * */
    public ListNode reverseList1(ListNode head) {
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
    /*
    * 递归法
    * */
    public ListNode reverseList2(ListNode head) {
        return reverseListInt(head,null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode tempnode = null;
        tempnode = head;
        head = head.next;
        tempnode.next = newHead;
        return  reverseListInt(head,tempnode);

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.reverseList2(ListNode.createTestData("[1,2,3,4,5]")));
    }


}
