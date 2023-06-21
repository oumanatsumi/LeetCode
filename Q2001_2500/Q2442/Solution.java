package Q2001_2500.Q2442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            set.add(reverse(i));
        }
        return set.size();
    }

    private int reverse(int num){
        List<Integer> nums = new ArrayList<>();
        while (num>0){
            nums.add(0,num % 10);
            num /=10;
        }
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums.get(i)*Math.pow(10,i);
        }
        return res;
    }

}
