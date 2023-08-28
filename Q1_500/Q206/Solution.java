package Q1_500.Q206;

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
