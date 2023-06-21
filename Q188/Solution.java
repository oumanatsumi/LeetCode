package Q188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for (int i = 0; i < 2*k; i+=2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],- prices[i]);
            for (int j = 1; j < 2*k; j++) {
                if(j % 2 == 1){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1] - prices[i]);
                }
            }
        }
        return dp[n-1][2*k-1];
    }
}
