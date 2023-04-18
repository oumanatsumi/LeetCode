package SPOffer57_1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int midCnt = 0, n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            if(target % 2 == 0 && nums[i] == target/ 2) midCnt++;
        }
        if(midCnt >= 2) return new int[]{target / 2, target / 2};
        for (int i = 0; i < n; i++) {
            if(set.contains(target - nums[i])){
                return new int[]{nums[i], target- nums[i]};
            }
        }
        return new int[]{-1, -1};
    }
}
