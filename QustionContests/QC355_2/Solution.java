package QustionContests.QC355_2;

import java.util.List;

class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int j = n-1;
        long sum = nums[n-1],max = -1;
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] <= sum){
                sum += nums[i];
            }else {
                j = i;
                sum = nums[j];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
