package Q1501_2000.Q1798;

import java.util.Arrays;

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int x = 0;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]<= x+1){
                x = x + coins[i];
            }else break;
        }
        return x+1;
    }
}
