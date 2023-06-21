package Q1_500.Q23;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode ltmp = lists[i];
            while (ltmp!=null){
                pq.add(ltmp.val);
                ltmp = ltmp.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode l1 = dummy;
        while (!pq.isEmpty()){
            l1.next = new ListNode(pq.poll());
            l1 = l1.next;
        }
        return dummy.next;
    }
}
