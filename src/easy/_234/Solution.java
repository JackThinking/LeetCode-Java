package easy._234;

import structure.ListNode;

import java.util.Stack;

/**
 * Created by Citrix on 2018/8/23.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        /*ListNode point = head;
        Stack<Integer> s = new Stack<>();
        while(point!=null){
            s.push(point.val);
            point = point.next;
        }
        while (head!=null){
            if (head.val!=s.pop()){
                return false;
            }
            else{
                head = head.next;
            }
        }
        return true;*/
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast!=null){
            slow = slow.next;//这个地方不要也可以吧
        }
        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if (slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode result = null;
        while(head!=null){
            ListNode point = head;
            head = head.next;
            point.next = result;
            result = point;
        }
        return result;
    }
}
