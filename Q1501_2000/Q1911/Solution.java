package Q1501_2000.Q1911;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - nums[i]);
        }
        return dp[n-1][0];
    }
}
