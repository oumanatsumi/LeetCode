package Q5;

class Solution {
    public String longestPalindrome(String s) {
        int totalLength = s.length();
        int maxLength = 1;
        String res = s.substring(0,1);
        for(int i =0;i<totalLength;i++)
        {
            int len=1;

            int left=i,right=i;
            while(left>=0 && right<totalLength && s.charAt(left)==s.charAt(right))
            {
                len=right-left+1;
                if(len>maxLength)
                {
                    maxLength=len;
                    res = s.substring(left,right+1);
                }
                left=left-1;
                right=right+1;
            }
            left=i;
            right=i+1;
            while(left>=0 && right<totalLength && s.charAt(left)==s.charAt(right))
            {
                len=right-left+1;
                if(len>maxLength)
                {
                    maxLength=len;
                    res = s.substring(left,right+1);
                }
                left=left-1;
                right=right+1;
            }
        }
        System.out.println(maxLength);
        return res;
    }



    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

        String res = s.longestPalindrome("bbcc");
        System.out.print(res);
    }
}
