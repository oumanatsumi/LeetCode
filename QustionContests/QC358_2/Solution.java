package QustionContests.QC358_2;

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
    public ListNode doubleIt(ListNode head) {
        ListNode l1=  head;
        StringBuilder s = new StringBuilder();
        while (l1 != null){
            s.append(l1.val);
            l1 = l1.next;
        }
        int len = s.length();
        int index = len-1;
        int flag = 0;
        StringBuilder sNew = new StringBuilder();
        while (index >= 0){
            int tmp = (s.charAt(index) - '0') *2 + flag;
            sNew.insert(0,tmp%10);
            if(tmp >= 10){
                flag = 1;
            }else {
                flag = 0;
            }
            index --;
        }
        if(flag == 1) {
            sNew.insert(0,1);
        }
        ListNode dummy = new ListNode(-1);
        l1 = dummy;
        for (int i = 0; i < sNew.length(); i++) {
            l1.next = new ListNode(sNew.charAt(i) - '0');
            l1 = l1.next;
        }

        return dummy.next;
    }
}
