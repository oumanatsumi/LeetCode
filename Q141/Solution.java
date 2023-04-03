package Q141;

import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean flag = false;
        while (head!=null){
            if(set.contains(head)) {
                flag = true;
                break;
            }
            set.add(head);
            head = head.next;
        }
        return flag;
    }
}
