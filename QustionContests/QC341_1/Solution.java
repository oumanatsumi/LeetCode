package QustionContests.QC341_1;

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] line = new int[m];
        int max = 0, maxIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                line[i] += mat[i][j];
            }
            if(line[i] > max){
                max = line[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, max};
    }
}
