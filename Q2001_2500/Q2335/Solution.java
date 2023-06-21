package Q2001_2500.Q2335;

import java.util.Arrays;

class Solution {
    public int fillCups(int[] amount) {
        int cnt = 0;
        Arrays.sort(amount);
        while (amount[1] != 0){
            amount[2] --;
            amount[1] --;
            cnt ++;
            Arrays.sort(amount);
        }
        cnt += amount[2];
        return cnt;
    }
}
