package Q1_500.Q141;

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

class Solution {
    // 方法1：Set
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        boolean flag = false;
//        while (head!=null){
//            if(set.contains(head)) {
//                flag = true;
//                break;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return flag;
//    }

    // 方法2：快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && slow != fast){
            slow = slow.next;
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
        }
        if(slow == fast) return true;
        return false;
    }
}
