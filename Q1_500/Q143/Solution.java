package Q1_500.Q143;

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
    public void reorderList(ListNode head) {
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
        int l = 0,r = n-1;
        while (l < r){
            l2.next = listNodes.get(l);
            l2 = l2.next;
            l++;
            if(l >= r) break;
            l2.next = listNodes.get(r);
            l2 = l2.next;
            r--;
        }
        head = dummyHead .next;

    }
}
