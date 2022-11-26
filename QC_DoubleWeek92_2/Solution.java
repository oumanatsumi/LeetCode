package QC_DoubleWeek92_2;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] onesRow = new int[row];
        int[] onesCol = new int[col];
        int[] zerosRow = new int[row];
        int[] zerosCol = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    onesRow[i] ++;
                    onesCol[j] ++;
                }else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return res;
    }
}
