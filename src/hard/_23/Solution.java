package hard._23;

import structure.ListNode;

/**
 * Created by Citrix on 2018/9/4.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sortByPartition(lists, 0, lists.length-1);
    }

    private ListNode sortByPartition(ListNode[] lists, int start, int end){
        /*
        * 递归先确定结束条件
        * */
        if (start == end){
            return lists[start];
        }
        /*
        * 经典的分治理念，切半，递归递归，合并
        * */
        int mid = start+(end-start)/2;
        ListNode left = sortByPartition(lists, start, mid);
        ListNode right = sortByPartition(lists, mid+1, end);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right){
        /*
        * 同样是递归，先要确定结束条件
        * */
        if (left == null || right == null){
            return left == null ? right : left;
        }
        /*
        * 链表合并总是要有连接的过程的
        * */
        if (left.val<right.val){
            left.next = merge(left.next,right);
            return left;
        }
        else {
            right.next = merge(left,right.next);
            return right;
        }
    }
}
