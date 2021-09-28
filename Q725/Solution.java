package Q725;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



class Solution {

        public ListNode[] splitListToParts(ListNode head, int k) {
            int n = 0;
            ListNode temp = head;
            while (temp != null) {
                n++;
                temp = temp.next;
            }
            int quotient = n / k, remainder = n % k;

            ListNode[] parts = new ListNode[k];
            ListNode curr = head;
            for (int i = 0; i < k && curr != null; i++) {
                parts[i] = curr;
                int partSize = quotient + (i < remainder ? 1 : 0);
                for (int j = 1; j < partSize; j++) {
                    curr = curr.next;
                }
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            return parts;
        }



    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

    }
}