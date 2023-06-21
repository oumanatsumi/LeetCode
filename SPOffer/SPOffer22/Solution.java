package SPOffer.SPOffer22;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 1;
        ListNode h = head;
        while (h!=null){
            h = h.next;
            n++;
        }
        for (int i = 1; i <= n-k; i++) {
            head= head.next;
        }
        return head;
    }
}
