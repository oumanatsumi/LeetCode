package Q1_500.Q16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int resSum = 0, minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int tar = target - nums[i];
            int l = i+1,r = n-1;
            while (l < r){
                if(Math.abs(tar - nums[l] - nums[r]) < minDis){
                    minDis = Math.abs(tar - nums[l] - nums[r]);
                    resSum = nums[i] + nums[l] + nums[r];
                }
                if(nums[l] + nums[r] == tar) return target;
                else if(nums[l] + nums[r] > tar) r--;
                else l++;
            }
        }
        return resSum;
    }
}
