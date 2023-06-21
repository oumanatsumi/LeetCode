package Q1615;

import java.util.Arrays;
import java.util.Map;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] map = new int[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            cnt[road[0]]++;
            cnt[road[1]]++;
            map[road[0]][road[1]] = 1;
            map[road[1]][road[0]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, map[i][j] == 1 ? cnt[i] + cnt[j]-1 : cnt[i] + cnt[j]);
            }
        }
        return max;
    }
}
