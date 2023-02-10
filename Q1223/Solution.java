package Q1223;

public class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][7];
        for (int i = 1; i < 7; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 7; j++) {
                long sum = 0L;
                for(int a:dp[i-1]){
                    sum += a;
                }
                int index = i - rollMax[j-1] -1;
                if(index >= 1){
                    for(int b: dp[index]){
                        sum -= b;
                        if(sum <0) sum += MOD;
                    }
                    sum += dp[index][j];
                }else if(index == 0){
                    sum-=1;
                }
                dp[i][j] = (int) (sum % MOD);
            }
        }

        int ans = 0;
        for(int d: dp[n]){
            ans = (ans + d)%MOD;
        }
        return ans;
    }

}
