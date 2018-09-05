package hard._138;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2018/9/5.
 */
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x;}
}

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();

        /*
        * 节点意义复制到map中
        * */
        RandomListNode point = head;
        while(point!=null){
            map.put(point,new RandomListNode(point.label));
            point = point.next;
        }
        /*
        * 指针重新指向开头的地方
        * */
        point = head;
        while(point!=null){
            map.get(point).next = map.get(point.next);
            map.get(point).random = map.get(point.random);
            point = point.next;
        }
        return map.get(head);
    }
}
