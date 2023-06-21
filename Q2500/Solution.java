package Q2500;

import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int[] row: grid){
            Arrays.sort(row);
        }
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(grid[i][j], max);
            }
            ans += max;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}});
    }
}
