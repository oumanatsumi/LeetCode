package Q1_500.Q445;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseListNode(l1);
        ListNode reverseL2 = reverseListNode(l2);
        ListNode p1 = reverseL1;
        ListNode p2 = reverseL2;
        ListNode dummyHead = new ListNode(-1);
        ListNode r = dummyHead;
        int flag = 0;
        while (p1 != null && p2!= null){
            int temp = p1.val + p2.val + flag;
            if(temp >= 10){
                r.next = new ListNode(temp % 10);
                flag = 1;
            }else {
                r.next = new ListNode(temp);
                flag = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
            r = r.next;
        }
        if(p1 == null && p2 != null){
            while (p2 != null){
                if(p2.val == 9 && flag == 1){
                    r.next = new ListNode(0);
                }else {
                    r.next = new ListNode(p2.val + flag);
                    flag = 0;
                }
                r = r.next;
                p2 = p2.next;
            }
        }else if(p2 == null && p1 != null){
            while (p1 != null){
                if(p1.val == 9 && flag == 1){
                    r.next = new ListNode(0);
                }else {
                    r.next = new ListNode(p1.val + flag);
                    flag = 0;
                }
                r = r.next;
                p1 = p1.next;
            }
        }
        if(flag == 1) r.next = new ListNode(1);
        return reverseListNode(dummyHead.next);
    }

    private ListNode reverseListNode(ListNode l){
        ListNode prev = null;
        ListNode cur = l;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3))));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        s.addTwoNumbers(l1,l2);
    }
}
