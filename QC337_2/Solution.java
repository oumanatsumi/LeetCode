package QC337_2;

class Solution {
    int n;
    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;
        int totalNum = n*n;
        if(grid[0][0] != 0) return false;
        int curX = 0, curY = 0 ;
        boolean flag = false;
        for (int i = 0; i < totalNum -1; i++) {
            if(check(curX - 2, curY -1, grid, i+1)){
                curX -= 2;
                curY -= 1;
                continue;
            }
            if(check(curX - 1, curY -2, grid, i+1)) {
                curX -= 1;
                curY -= 2;
                continue;
            }
            if(check(curX + 2, curY -1, grid, i+1)) {
                curX += 2;
                curY -= 1;
                continue;
            }
            if(check(curX + 1, curY -2, grid, i+1)) {
                curX += 1;
                curY -= 2;
                continue;
            }
            if(check(curX - 2, curY +1, grid, i+1)) {
                curX -= 2;
                curY += 1;
                continue;
            }
            if(check(curX - 1, curY +2, grid, i+1)) {
                curX -= 1;
                curY += 2;
                continue;
            }
            if(check(curX + 2, curY +1, grid, i+1)) {
                curX += 2;
                curY += 1;
                continue;
            }
            if(check(curX + 1, curY +2, grid, i+1)) {
                curX += 1;
                curY += 2;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean check(int x,int y,int[][] grid,int target){
        if(x < 0 || y <0 || x >= n || y >= n) return false;
        if(grid[x][y] == target) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.checkValidGrid(new int[][]{  {0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}});
    }
}
