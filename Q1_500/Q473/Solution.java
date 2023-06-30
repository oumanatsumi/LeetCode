package Q1_500.Q473;

import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0, n = matchsticks.length;
        for(int m:matchsticks) total+=m;
        if(total % 4 != 0) return false;
        int side = total /4;
        Integer[] matches = new Integer[n];
        Arrays.sort(matchsticks);
        for (int i = 0; i < n; i++) {
            matches[i] =
        }
    }

    private void dfs(int side, int sideCnt, )
}
