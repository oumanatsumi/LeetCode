package QustionContests.QC344_3;

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] colors = new int[n];
        int curCnt = 0;
        for (int i = 0; i < queries.length; i++) {
            int curIndex = queries[i][0];
            int curColor = queries[i][1];
            if(curIndex > 0){
                // 左侧相邻减少
                if(colors[curIndex]!= 0 && colors[curIndex] == colors[curIndex-1] && curColor!= colors[curIndex]){
                    curCnt -- ;
                }
                // 左侧相邻增加
                if(colors[curIndex] != colors[curIndex-1] && curColor == colors[curIndex-1]){
                    curCnt ++ ;
                }
            }
            if(curIndex < n-1){
                // 右侧相邻减少
                if(colors[curIndex]!= 0 && colors[curIndex] == colors[curIndex+1] && curColor!= colors[curIndex]){
                    curCnt -- ;
                }
                // 右侧相邻增加
                if(colors[curIndex] != colors[curIndex+1] && curColor == colors[curIndex+1]){
                    curCnt ++ ;
                }
            }
            colors[curIndex] = curColor;
            ans[i] = curCnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.colorTheArray(4, new int[][]{
                {0,2},{1,2},{3,1},{1,1},{2,1}});
    }
}
