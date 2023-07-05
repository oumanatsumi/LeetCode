package Q1_500.Q300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max == -1 ? 1 : max +1 ;
        }
        int res = -1;
        for(int i: dp){
            res = Math.max(res, i);
        }
        return res;
    }
}
