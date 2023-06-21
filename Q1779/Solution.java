package Q1779;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (Math.abs(points[i][0] - x + points[i][1] - y) < minDis) {
                    minDis = Math.abs(points[i][0] - x + points[i][1] - y);
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
