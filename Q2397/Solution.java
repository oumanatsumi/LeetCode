package Q2397;

public class Solution {
    public int maximumRows(int[][] mat, int cols) {
       int m = mat.length,n = mat[0].length;
       if(n == cols){
           return m;
       }
        int[] oneCount = calcOneCount(mat);

        int minIndex=0, min = Integer.MAX_VALUE;
        for (int i = 0; i < oneCount.length; i++) {
            if(oneCount[i] < min && oneCount[i]!=0){
                min = oneCount[i];
                minIndex =i;
            }
        }

       while (cols >= min){
           for(int i = 0; i < mat[0].length;i++){
               if(mat[minIndex][i] == 1){
                   mat = deleteCol(mat, i);
               }
           }
           cols = cols - min;

           oneCount = calcOneCount(mat);
           minIndex=0;
           min = Integer.MAX_VALUE;
           for (int i = 0; i < oneCount.length; i++) {
               if(oneCount[i] < min && oneCount[i]!=0){
                   min = oneCount[i];
                   minIndex =i;
               }
           }
       }


        int ans = 0;
       oneCount = calcOneCount(mat);
        for(int i:oneCount){
            if (i == 0) ans++;
        }
        return ans;
    }

    private int[] calcOneCount(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] oneCount = new int[m];
        for (int i = 0; i < m; i++) {
            for (int a : mat[i]) {
                oneCount[i] += a;
            }
        }
        return oneCount;
    }


    private int[][] deleteCol(int[][] mat, int cols) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][cols] = 0;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{1,0,1},{0,1,1},{0,0,1}};
        int cols = 2;
        Solution s = new Solution();
        int res = s.maximumRows(mat,cols);
        System.out.println(res);
    }
}

