package Q147;

public class Solution {
    public class ListNode {
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

    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(5001, head);
        ListNode h = null;
        while (sorted != null){
            int minVal = 5001;
            ListNode cur = sorted.next;
            ListNode prev = sorted;
            ListNode tempMin = null;
            while (cur != null){
                if(minVal > cur.val){
                    tempMin = prev;
                    minVal = cur.val;
                }
                prev = prev.next;
                cur = cur.next;
            }
            if(tempMin == null){
                sorted = sorted.next;
                continue;
            }
            ListNode temp = tempMin.next;
            tempMin.next = tempMin.next.next;

            temp.next = sorted.next;
            sorted.next = temp;
            if(h == null) h = sorted;
            else sorted = sorted.next;

        }
        return h;
    }

}
