package Q828;

import java.util.Arrays;

public class Solution {
    // 超时
//    public int uniqueLetterString(String s) {
//        int ans = 0;
//        //滑动窗口
//        for (int i = 1; i <= s.length(); i++) {
//            for(int j = 0; j<= s.length()-i;j++){
//                ans += countUniqueLetter(s.substring(j,j+i));
//            }
//        }
//        return ans;
//    }
//
//    private int countUniqueLetter(String s){
//        if(s.length() == 1) return 1;
//        int[] map = new int[26];
//        for(char c:s.toCharArray()){
//            map[c-'A'] ++;
//        }
//        int ans = 0;
//        for(int i:map){
//            if(i==1) ans++;
//        }
//        return ans;
//    }

    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] cur = new int[26];
        Arrays.fill(cur,-1);
        for(int i=0;i<n;i++){
            l[i] = cur[cs[i] - 'A'];
            cur[cs[i] - 'A'] = i;
        }
        Arrays.fill(cur,n);
        for(int i=n-1;i>=0;i--){
            r[i] = cur[cs[i] - 'A'];
            cur[cs[i] - 'A'] = i;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += (i - l[i])*(r[i] - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.uniqueLetterString("LEETCODE");
        System.out.println(res);
    }
}
