package Q501_1000.Q695;

import java.util.HashSet;
import java.util.Set;

class Solution {
    int m, n;
    // 方法1 ： bfs
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) bfs(grid,i*n+j+2, i, j);
            }
        }
        int[] map = new int[m*n+3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=0) map[grid[i][j]] ++;
            }
        }
        int max = 0;
        for(int i: map) max = Math.max(i, max);
        return max;
    }

    private void bfs(int[][] grid, int curNo, int x, int y){
        if(grid[x][y] == 1) grid[x][y] = curNo;
        if(x > 0 && grid[x-1][y] == 1) bfs(grid, curNo, x-1 ,y);
        if(x < m - 1 && grid[x+1][y] == 1) bfs(grid, curNo, x+1 ,y);
        if(y > 0 && grid[x][y-1] == 1) bfs(grid, curNo, x ,y-1);
        if(y < n - 1 && grid[x][y+1] == 1) bfs(grid, curNo, x ,y+1);
    }

    // 方法2：dfs

}
