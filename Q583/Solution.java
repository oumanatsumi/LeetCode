package Q583;

public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1+1][length2+1];
        //初始化，第一行第一列先赋0
        for(int i=0;i<=length1;i++)
        {
            dp[i][0]=0;
        }

        for(int i=0;i<=length2;i++)
        {
            dp[0][i]=0;
        }
        int max = 0;
        for(int i=1;i<=length1;i++)
        {
            for(int j=1;j<=length2;j++)
            {
                char letter1=word1.charAt(i-1);
                char letter2=word2.charAt(j-1);
                if(letter1 == letter2)
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    if(dp[i-1][j] > dp[i][j-1])
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]=dp[i][j-1];
                    }
                }
                if(dp[i][j]>max)
                {
                    max = dp[i][j];
                }
            }
        }
        int res = length1+length2-max*2;

        return res;
    }


    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        String s1 = "sea";
        String s2 = "eat";

        int res = s.minDistance(s1, s2);
        System.out.print(res);
    }
}