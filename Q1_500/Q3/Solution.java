package Q1_500.Q3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        Map<Character, Integer> lastAppearIndex = new HashMap<>();
        int[] dp = new int[n];
        dp[0] = 1;
        lastAppearIndex.put(s.charAt(0),0);
        int max = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if(!lastAppearIndex.containsKey(c)){
                dp[i] = dp[i-1]+1;
            }else if(i - dp[i-1] > lastAppearIndex.get(c)) {
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = i - lastAppearIndex.get(c);
            }
            lastAppearIndex.put(c, i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
