package Q1001_1500.Q1329;

import java.util.PriorityQueue;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        PriorityQueue<Integer>[] pqs = new PriorityQueue[m+n-1];
        for (int i = 0; i < m+n-1; i++) {
            pqs[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pqs[i-j + n-1].add(mat[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = (int) pqs[i-j + n-1].poll();
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] res = s.diagonalSort(mat);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(" "+res[i][j]);
            }
            System.out.println();
        }
    }
}
