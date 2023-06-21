package Q2367;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(set.contains(nums[i] + diff) && set.contains(nums[i] + diff*2)){
                ans ++;
            }
        }
        return ans;
    }
}
