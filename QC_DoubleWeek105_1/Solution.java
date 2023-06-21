package QC_DoubleWeek105_1;

import java.util.Arrays;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(money < prices[0] + prices[1]){
            return money;
        }else {
            return money - (prices[0] + prices[1]);
        }
    }
}
