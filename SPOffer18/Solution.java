package SPOffer18;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode prev = h, cur = head;
        while(cur!= null){
            if(cur.val == val){
                prev.next = cur.next;
                break;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        return h.next;
    }
}
