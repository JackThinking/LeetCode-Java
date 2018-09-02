package hard._148;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/31.
 */
public class Solution {

    /*
    * 链表合并的递归方式，妙的很，理解上需要从最后一步反推，链表的连接像是倒着连一样
    * */
    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null){
            return h2;
        }

        if (h2 == null){
            return h1;
        }
        if (h1.val<h2.val){
            h1.next = merge(h1.next,h2);
            return h1;
        }
        else{
            h2.next = merge(h1,h2.next);
            return h2;
        }

    }

    /*
    * 同样是递归，原理是归并排序的原理，先分开排序再进行合并，具体原理再多理解一下
    * */
    public ListNode sortList(ListNode head) {
        /*
        * 归并的第一步：确定最后的返回条件
        * */
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }

        /*
        * 快慢指针达到二分的效果
        * */
        ListNode slow = head, fast = head, pre = head;//pre存储slow指针的上一个节点，用于分割

        /*
        * 由于有快指针，循环条件要以快的那个为准，而且要有两种情况，以防跳到null
        * */
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        /*
        * x.next进行分割；不同于slow = slow.next是指针滑动
        * */
        pre.next = null;
        /*
        * 归并的一般推演逻辑
        * */
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);
        return merge(h1,h2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.sortList(ListNode.createTestData("[2,1,3,5]")));
    }
}
