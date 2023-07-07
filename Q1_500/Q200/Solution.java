package Q1_500.Q200;

import java.util.HashSet;
import java.util.Set;

class Solution {
    int m, n;
    public int numIslands(char[][] grid) { 
        m = grid.length;
        n = grid[0].length;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') bfs(grid, map, i*n+j+1, i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               set.add(map[i][j]);
            }
        }
        return set.size();
    }

    private void bfs(char[][] grid, int[][] map, int curNo, int x, int y){
        if(map[x][y] == 0) map[x][y] = curNo;
        if(x > 0 && grid[x-1][y] == '1' && map[x-1][y] == 0) bfs(grid, map, curNo, x-1 ,y);
        if(x < m - 1 && grid[x+1][y] == '1' && map[x+1][y] == 0) bfs(grid, map, curNo, x+1 ,y);
        if(y > 0 && grid[x][y-1] == '1' && map[x][y-1] == 0) bfs(grid, map, curNo, x ,y-1);
        if(y < n - 1 && grid[x][y+1] == '1' && map[x][y +1] == 0) bfs(grid, map, curNo, x ,y+1);
    }

}
