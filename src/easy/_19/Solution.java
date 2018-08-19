package easy._19;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/19.
 */
public class Solution {
    /*
    * 删除节点可以参考最基本的那个，但是问题是如何找到倒数第二个
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start,fast = start;//同时指向start，slow,fast操作的时候会影响到start
        start.next = head;//把头指向head
        /*
        * 先派fast先走两步，fast在这里只是充当探底，找到倒数第二个数的作用
        * */
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        /*
        * 一起走两步
        * */
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        /*
        * 关键的操作，跳过slow后面的那个
        * */
        slow.next = slow.next.next;//但是为什么要设置一个头呢，是不是因为怕影响原始的你的node呢
        return start.next;
    }

}
