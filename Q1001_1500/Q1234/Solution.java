package Q1001_1500.Q1234;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int balancedString(String s) {
        int len = s.length();
        int n = len / 4;
        Map<Character,Integer> map = new HashMap<>();
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        for(char c : s.toCharArray()){
            switch (c){
                case 'Q': {
                    map.put('Q', map.getOrDefault('Q',0)+1);
                    break;
                }
                case 'W': {
                    map.put('W', map.getOrDefault('W',0)+1);
                    break;
                }
                case 'E': {
                    map.put('E', map.getOrDefault('E',0)+1);
                    break;
                }
                case 'R': {
                    map.put('R', map.getOrDefault('R',0)+1);
                    break;
                }
            }
        }
        if(map.get('Q') == n && map.get('W') == n && map.get('E') == n && map.get('R') == n){
            return 0;
        }
        int cnt = len-1;
        int left = 0;
        for (int right = left; right < len; right++) {
            char c = s.charAt(right);
            map.put(c,map.get(c)-1);
            while(map.get('Q') <= n && map.get('W') <=n && map.get('E')<= n && map.get('R') <= n){
                cnt = Math.min(cnt,right- left +1);
                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
            }
        }
        return cnt;

    }
}
