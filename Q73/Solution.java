package Q73;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    col.add(j);
                    row.add(i);
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(row.contains(i) || col.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }

        }
    }

}
