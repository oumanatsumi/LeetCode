package Q1669;


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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = null, right = null, cur = list1;
        int curIndex = 0;
        while (cur!= null){
            if(curIndex == a-1){
                left = cur;
            }else if(curIndex == b+1){
                right = cur;
            }
            curIndex++;
            cur = cur.next;
        }
        left.next = list2;
        while (list2.next!= null){
            list2 = list2.next;
        }
        list2.next = right;
        return list1;
    }
}
