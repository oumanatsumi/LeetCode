package Q2001_2500.Q2487;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode l1 = head;
        while (l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        if(list.size() == 1) return head;

        List<Integer> newList = new ArrayList<>();
        int curMax = list.get(list.size()-1);
        newList.add(curMax);

        for (int i = list.size()-2; i >= 0 ; i--) {
            if(list.get(i) >= curMax) {
                curMax = list.get(i);
                newList.add(curMax);
                System.out.println(curMax);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        l1 = dummyHead;
        for (int i = newList.size()-1; i >= 0 ; i--) {
            l1.next = new ListNode(newList.get(i));
            l1 = l1.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(5);
        ListNode l2= new ListNode(2);
        ListNode l3 = new ListNode(14);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        s.removeNodes(l1);
    }
}
