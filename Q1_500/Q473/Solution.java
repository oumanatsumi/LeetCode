package Q1_500.Q473;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean totalFlag = false;
    Set<Integer> set = new HashSet<>();
    public boolean makesquare(int[] matchsticks) {
        int total = 0, n = matchsticks.length;
        for(int m:matchsticks) total+=m;
        if(total % 4 != 0) return false;
        int side = total /4;
        Integer[] matches = new Integer[n];
        Arrays.sort(matchsticks);
        for (int i = 0; i < n; i++) {
            matches[i] = matchsticks[n - i - 1];
        }
        dfs(side, 0 , 0, matches, 0);
        return totalFlag;
    }

    private void dfs(int requireSideLength, int curSideLength, int sideCnt, Integer[] matches, int stats){
        if(totalFlag) return;
        if(set.contains(stats)) return;
        for (int i = 0; i < matches.length; i++) {
            if((stats & 1 << i) == 0 && matches[i] + curSideLength <= requireSideLength){
                stats |= 1 << i;
                if(curSideLength + matches[i] == requireSideLength){
                    if(sideCnt + 1 == 4) {
                        totalFlag = true;
                        return;
                    }
                    dfs(requireSideLength, 0, sideCnt+1, matches, stats);
                }else {
                    dfs(requireSideLength, curSideLength + matches[i], sideCnt, matches, stats);
                }
                stats ^= 1 << i;
            }
        }
        set.add(stats);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makesquare(new int[]{1, 1, 2, 2, 2}));
    }
}
