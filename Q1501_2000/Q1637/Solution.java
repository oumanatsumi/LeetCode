package Q1501_2000.Q1637;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < points.length; i++) {
            res =Math.max(res,points[i][0] - points[i-1][0]);
        }
        return res;
    }
}
