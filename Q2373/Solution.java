package Q2373;

import java.util.stream.IntStream;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1 ; j++) {
                int max = -1;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <=j+1 ; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                res[i-1][j-1] = max;
            }
        }
        return res;
    }
}
