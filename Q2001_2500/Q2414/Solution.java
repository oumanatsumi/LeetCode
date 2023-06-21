package Q2001_2500.Q2414;

class Solution {
    public int longestContinuousSubstring(String s) {
        char[] cs = s.toCharArray();
        int ans = 1;
        int startPos = 0;
        for (int i = 1; i < cs.length; i++) {
            if(cs[i-1] == cs[i]-1){
                cs[i-1] = cs[i];
                ans = Math.max(i - startPos+1, ans);
            }
            else {
                startPos = i;
            }
        }
        return ans;
    }
}
