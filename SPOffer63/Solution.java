package SPOffer63;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[] minLeft = new int[n];
        int[] dp = new int[n];
        minLeft[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i-1],prices[i]);
        }

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], prices[i]-minLeft[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
