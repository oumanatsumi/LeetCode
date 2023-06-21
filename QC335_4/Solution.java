package QC335_4;

class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int n =  types.length, m = target;
        int[][] f = new int[1001][1001];
        int cnt = 0;
        for(int i=1;i<=n;i++) {
            int v = 1;
            int w = types[i-1][1];
            int s = types[i-1][0];
            for(int j=1;j<=m;j++) {
                for(int k=0;k<=s;k++) {
                    if(j<k*v) continue;
                    f[i][j] = Math.max(f[i][j],f[i-1][j-k*v]+k*w);
                    if(f[i][j] == target) cnt ++;
                }
            }
        }
        return cnt;
    }
}
