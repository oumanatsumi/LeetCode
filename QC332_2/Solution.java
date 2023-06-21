package QC332_2;

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0L;
        for (int i = 0; i < n; i++) {
            int low = lower - nums[i];
            int high = upper - nums[i];
            int l = lowBound(nums, low, i+1);
            int r = lowBound2(nums, high,i+1);
            res += (r - l)+1;
        }
        return res;
    }

    int lowBound (int[] nums, int target, int left){
        int right = nums.length-1;
        while(left <= right){
            int mid = (left +right)>>>1;
            if(nums[mid] < target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }

    int lowBound2 (int[] nums, int target, int left){
        int right = nums.length-1;
        while(left <= right){
            int mid = (left +right)>>>1;
            if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countFairPairs(new int[]{0,1,7,4,4,5},3,6);
    }
}
