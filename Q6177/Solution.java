package Q6177;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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
