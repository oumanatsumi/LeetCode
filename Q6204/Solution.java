package Q6204;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1001 ;
        for(int i : nums){
            set.add(i);
            if(set.contains(-i)){
                max = Math.max(max,Math.abs(i));
            }
        }
        if(max == -1001) return -1;
        return max;
    }
}
