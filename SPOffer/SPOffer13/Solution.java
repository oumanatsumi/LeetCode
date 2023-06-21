package SPOffer.SPOffer13;

class Solution {
    int res = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] stats = new boolean[m][n];
        bfs(stats,0,0,k);
        return res;
    }

    private int calc(int i){
        int ret = 0;
        while(i > 0){
            ret += i % 10;
            i /= 10;
        }
        return ret;
    }

    private void bfs(boolean[][] stats, int i ,int j, int k){
        stats[i][j] = true;
        if(calc(i) + calc(j) <= k){
            res ++;
            if(i > 0 && !stats[i-1][j]) bfs(stats, i-1, j , k);
            if(i+1 < stats.length && !stats[i+1][j]) bfs(stats, i+1, j , k);
            if(j > 0 && !stats[i][j-1]) bfs(stats, i, j-1 , k);
            if(j+1 < stats[0].length && !stats[i][j+1]) bfs(stats, i, j+1 , k);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.movingCount(16,8,1);
    }
}
