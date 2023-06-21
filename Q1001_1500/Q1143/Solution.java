package Q1001_1500.Q1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

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
                char letter1=text1.charAt(i-1);
                char letter2=text2.charAt(j-1);
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


        return max;
    }
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        String s1= "abcde";
        String s2= "acde";

        int res = s.longestCommonSubsequence(s1,s2);


        System.out.print(res);
    }

}
