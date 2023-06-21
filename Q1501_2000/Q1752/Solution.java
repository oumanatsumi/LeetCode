package Q1501_2000.Q1752;

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean point = false;
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]){
                if(!point) point = true;
                else return false;
            }
        }
        return !point || nums[n-1] <= nums[0];
    }
}
