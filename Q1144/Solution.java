package Q1144;

import java.util.Arrays;

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int r1 = 0 ,r2 = 0;
        int n = nums.length;
        if(n == 1) return 0;
        r1 += Math.max(0,nums[0] - nums[1] + 1);
        if(n % 2 == 0){
            r2 += Math.max(0,nums[n-1] - nums[n-2] + 1);
        }else {
            r1 += Math.max(0,nums[n-1] - nums[n-2] + 1);
        }
        for (int i = 1; i < n -1; i++) {
            if(i % 2 == 0){
                int min = Math.min(nums[i - 1], nums[i+1]) - 1;
                r1 += Math.max(0,nums[i] - min);
            }else {
                int min = Math.min(nums[i - 1], nums[i+1]) - 1;
                r2 += Math.max(0,nums[i] - min);
            }
        }
        return Math.min(r1,r2);
    }

}
