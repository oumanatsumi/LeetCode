package LeetCode.Q807;


public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] skylineR = new int[len];
        int[] skylineL = new int[len];
        for(int i =0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                skylineR[i] = Math.max(grid[i][j],skylineR[i]);
                skylineL[j] = Math.max(grid[i][j],skylineL[j]);
            }
        }
        int res =0;
        for(int i =0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(grid[i][j]<Math.min(skylineR[i],skylineL[j]))
                {
                    res+=Math.min(skylineR[i],skylineL[j])-grid[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[][] g= {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int res = s.maxIncreaseKeepingSkyline(g);
        System.out.println(res);
    }

}
