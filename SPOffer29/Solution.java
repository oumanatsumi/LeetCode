package SPOffer29;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[]{};
        int n = matrix[0].length;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int curDirection = 0;
        int[] res = new int[m * n];
        int num = 0, i = 0, j = 0;
        while (num < m * n - 1) {
            res[num] = matrix[i][j];
            while (direction[curDirection][0] + i < 0 || direction[curDirection][0] + i >= m
                    || direction[curDirection][1] + j < 0 || direction[curDirection][1] + j >= n ||
                    visited[direction[curDirection][0] + i][direction[curDirection][1] + j]) {
                curDirection = (curDirection + 1) % 4;
            }
            visited[i][j] = true;
            i = direction[curDirection][0] + i;
            j = direction[curDirection][1] + j;
            num++;
        }
        res[num] = matrix[i][j];
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
