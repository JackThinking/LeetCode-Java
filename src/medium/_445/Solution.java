package medium._445;

import structure.ListNode;

import java.util.Stack;

/**
 * Created by Citrix on 2018/8/25.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.add(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int temp = 0;
        while(! s1.empty() || !s2.empty()){
            if (! s1.empty()){
                temp += s1.pop();
            }
            if (! s2.empty()){
                temp += s2.pop();
            }
            head.val = temp%10;
            ListNode tempnode = new ListNode(temp/10);//其实代表最后的进位
            tempnode.next = head;
            head = tempnode;
            temp = temp/10;
        }
        return head.val == 0 ? head.next:head;
    }
}
