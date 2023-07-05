package Q1_500.Q74;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m-1, mid;
        while (l <= r){
            mid = (l+r)>>>1;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target) l = mid +1 ;
            else r = mid - 1;
        }
        int line = Math.max(0, r);
        l = 0; r = n-1;
        while (l <= r){
            mid = (l+r)>>>1;
            if(matrix[line][mid] == target) return true;
            else if(matrix[line][mid] < target) l = mid +1 ;
            else r = mid - 1;
        }
        return false;
    }
}
