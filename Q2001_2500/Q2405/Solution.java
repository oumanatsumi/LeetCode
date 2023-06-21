package Q2001_2500.Q2405;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int partitionString(String s) {
        int cnt = 1;
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }else {
                set.clear();
                set.add(c);
                cnt++;
            }
        }

        return cnt;
    }

}
