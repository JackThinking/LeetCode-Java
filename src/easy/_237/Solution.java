package easy._237;

import structure.ListNode;

/**
 * Created by Citrix on 2018/8/19.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;//没有删除节点，而是把后面的节点转移到改节点上
        node.next = node.next.next;
    }

}
