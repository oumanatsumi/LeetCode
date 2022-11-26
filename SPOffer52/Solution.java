package SPOffer52;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA, lB = headB;
        while (lA != null || lB != null){
            if(lA == lB) return lA;
            lA = lA == null? headB:lA.next;
            lB = lB == null? headA:lB.next;
        }
        return null;
    }
}
