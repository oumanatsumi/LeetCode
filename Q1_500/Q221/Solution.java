package Q1_500.Q221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int maxSize = 0;
        int[][] dp = new int[m][n];
        if(matrix[0][0] == '1'){
            dp[0][0] = 1;
            maxSize = 1;
        }
        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxSize = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxSize = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
}
