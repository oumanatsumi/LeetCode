package SPOffer42;

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1]<0 ? nums[i] : nums[i] + dp[i-1];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
