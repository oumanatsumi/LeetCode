package Q764;

import java.util.Arrays;

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] martix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(martix[i],true);
        }
        for(int[] mine:mines){
            martix[mine[0]][mine[1]] = false;
        }
        // 二分
        int l = 0,r = n/2;
        boolean[] able = new boolean[r+1];
        int k = (l+r)/2;
        while (l <= r){
            k = (l+r)/2;
            boolean flag = false;
            for (int i = k; i < n-k; i++) {
                for (int j = k; j < n-k ; j++) {
                    if(check(martix, i,j,k)){
                        l = k + 1;
                        able[k] = true;
                        flag = true;
                        i = n-k;
                        j = n-k;
                    }
                }
            }
            if(!able[k]) r = k - 1;
        }
        for (int i = r; i >= 0; i--) {
            if(able[i]) return i+1;
        }
        return 0;
    }

    private boolean check(boolean[][] martix, int centerX, int centerY, int k){
        for (int i = centerX - k; i <= centerX + k ; i++) {
            if(!martix[i][centerY]) return false;
        }
        for (int i = centerY - k; i <= centerY + k ; i++) {
            if(!martix[centerX][i]) return false;
        }
        return true;
    }
}
