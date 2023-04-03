package Q121;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], n = prices.length;
        int dp = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] > min){
                dp = Math.max(dp, prices[i]-min);
            }
            min = Math.min(min, prices[i]);
        }
        return dp;
    }
}
