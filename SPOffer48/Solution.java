package SPOffer48;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 暴力
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        if(n==0) return 0;
//        Set<Character> set;
//        int max = 1;
//        for (int i = 0; i < n; i++) {
//            int len = 0;
//            set = new HashSet<>();
//            for (int j = i; j < n; j++) {
//                if(!set.contains(s.charAt(j))){
//                    set.add(s.charAt(j));
//                    len++;
//                }else {
//                    break;
//                }
//            }
//            max = Math.max(len,max);
//        }
//        return max;
//    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] map = new int[129];
        int[] dp = new int[n];
        int max = 1 ;
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        dp[0] = 1;
        map[s.charAt(0)] = 0;
        for (int i = 1; i < n; i++) {
            if(dp[i-1] < i - map[s.charAt(i)]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = i - map[s.charAt(i)];
            }
            max = Math.max(dp[i], max);
            map[s.charAt(i)] = i;
        }
        return max;
    }
}
