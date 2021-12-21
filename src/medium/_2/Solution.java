package medium._2;

import structure.ListNode;

/** Created by Citrix on 2018/8/25. */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 生成链表
    // 需要中间变量
    // 指针的滑动
    // 链表的初始值地址
    ListNode result = new ListNode(0);
    ListNode point = result;
    int sum = 0;
    while (l1 != null || l2 != null || sum != 0) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      ListNode tmpX = new ListNode(sum % 10);
      point.next = tmpX;
      point = point.next;
      sum = sum / 10;
    }
    return result.next;
  }
}
