package medium._61;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/30.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k==0){
            return head;
        }
        ListNode cur = head, pre = null;
        int count = 0;
        while(cur!=null){
            pre = cur;
            cur = cur.next;
            count++;
        }
        pre.next = head;
        k %= count;
        int left = count-k;
        cur = head;
        while(left>0){
            pre = cur;
            cur = cur.next;
            left--;
        }
        pre.next = null;
        return cur;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.rotateRight(ListNode.createTestData("[1,2,3,4,5]"),2));
    }
}
