package Q799;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured >= 5050) return 1.0f;
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = Math.max(dp[i-1][j] - 1 , 0) / 2;
                else if(j == i) dp[i][j] = Math.max(dp[i-1][j-1] -1, 0) / 2;
                else dp[i][j] = Math.max(dp[i-1][j] - 1 , 0) / 2 + Math.max(dp[i-1][j-1] -1, 0) / 2;
            }
        }
        return Math.max(Math.min(dp[query_row][query_glass], 1),0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.champagneTower(25,6,1));
    }
}

