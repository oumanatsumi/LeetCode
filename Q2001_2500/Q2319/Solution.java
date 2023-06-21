package Q2001_2500.Q2319;

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i == j || i + j == size -1){
                    if(grid[i][j] == 0) return false;
                }else {
                    if(grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
