package Q501_1000.Q931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] line: dp){
            Arrays.fill(line, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min =  Math.min(dp[i][j], dp[i-1][j] + matrix[i][j]);
                if(j != 0) min = Math.min(min ,dp[i-1][j-1] + matrix[i][j]);
                if(j != n-1) min = Math.min(min, dp[i-1][j+1] + matrix[i][j]);
                dp[i][j] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[n-1][i], res);
        }
        return res;
    }
}
