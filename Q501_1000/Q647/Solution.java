package Q501_1000.Q647;

import java.util.Arrays;

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            ans ++;
        }
        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                f[i][i+1] = true;
                ans++;
            }
        }
        // 开始dp
        for (int i = n-3; i >= 0; i--) {
            for (int j = i+2; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && f[i+1][j-1]){
                    f[i][j] =  true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
