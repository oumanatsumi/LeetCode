package Q1501_2000.Q1769;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] cnt = new int[n];
        cnt[0] = boxes.charAt(0) == '0'? 0 :1 ;
        for (int i = 1; i < n; i++) {
            if(boxes.charAt(i) == '1') cnt[i] = cnt[i-1]+1;
            else cnt[i] = cnt[i-1];
        }
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            if(boxes.charAt(i) == '1') ans[0]+=i;
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] + cnt[i-1] - (cnt[n-1] - cnt[i-1]);
        }
        return ans;
    }
}
