package Q1_500.Q25;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l1 = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (l1 != null){
            listNodes.add(l1);
            l1 = l1.next;
        }
        int n = listNodes.size();
        for (int i = 0; i < n; i++) {
            listNodes.get(i).next = null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode l2 = dummyHead;
        int groupNum = listNodes.size() / k;
        for (int i = 0; i < groupNum; i++) {
            for (int j = k-1; j >= 0; j--) {
                l2.next = listNodes.get(i*k + j);
                l2 = l2.next;
            }
        }
        if(groupNum * k != n){
            for (int i = groupNum * k; i < n; i++) {
                l2.next = listNodes.get(i);
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}
