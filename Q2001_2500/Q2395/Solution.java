package Q2001_2500.Q2395;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findSubarrays(int[] nums) {
        if(nums.length == 2 )return false;
        Set<Integer> map = new HashSet<>();
        for(int i =0;i<nums.length-1;i++){
            int sum = nums[i]+ nums[i+1];
            if(map.contains(sum)){
                return true;
            }
            map.add(sum);
        }
        return false;
    }
}
