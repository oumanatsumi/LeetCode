package Q1501_2000.Q1828;

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int qLen = queries.length;
        int pointNum = points.length;
        int[] ans = new int[qLen];
        int px,py,pr,disX,disY;
        for (int i = 0; i < qLen; i++) {
            px = queries[i][0];
            py = queries[i][1];
            pr = queries[i][2];
            for (int j = 0; j < pointNum; j++) {
                disX = (points[j][0] - px) * (points[j][0] - px);
                disY = (points[j][1] - py) * (points[j][1] - py);
                if(disX + disY <= pr * pr) ans[i]++;
            }
        }
        return ans;
    }
}
