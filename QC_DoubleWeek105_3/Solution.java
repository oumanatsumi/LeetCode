package QC_DoubleWeek105_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long maxStrength(int[] nums) {
        long res = 1l;
        if(nums.length == 1) return nums[0];
        boolean hasZero = false;
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        for(int i:nums){
            if(i < 0) negative.add(i);
            if(i > 0) positive.add(i);
            if(i == 0) hasZero = true;
        }
        for (int i : positive) {
            res *= i;
        }
        Collections.sort(negative);
        if(negative.size() % 2 == 0){
            for(int i: negative){
                res *= i;
            }
        }else {
            for (int i = 0; i < negative.size()-1; i++) {
                res *= negative.get(i);
            }
        }
        if(negative.size() <= 1 && positive.size() == 0 && hasZero) return 0;
        return res;
    }
}
