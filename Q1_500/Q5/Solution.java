package Q1_500.Q5;

class Solution {

//    public String longestPalindrome(String s) {
//        int totalLength = s.length();
//        int maxLength = 1;
//        String res = s.substring(0,1);
//        for(int i =0;i<totalLength;i++)
//        {
//            int len=1;
//
//            int left=i,right=i;
//            while(left>=0 && right<totalLength && s.charAt(left)==s.charAt(right))
//            {
//                len=right-left+1;
//                if(len>maxLength)
//                {
//                    maxLength=len;
//                    res = s.substring(left,right+1);
//                }
//                left=left-1;
//                right=right+1;
//            }
//            left=i;
//            right=i+1;
//            while(left>=0 && right<totalLength && s.charAt(left)==s.charAt(right))
//            {
//                len=right-left+1;
//                if(len>maxLength)
//                {
//                    maxLength=len;
//                    res = s.substring(left,right+1);
//                }
//                left=left-1;
//                right=right+1;
//            }
//        }
//        System.out.println(maxLength);
//        return res;
//    }

    //dp
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 1;
        boolean[][] f = new boolean[n][n];
        String res = s.substring(0,1);
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                f[i][i+1] = true;
                max = 2;
                res = s.substring(i,i+2);
            }
        }
        for (int i = n-3; i >=0 ; i--) {
            for (int j = i+2; j < n; j++) {
                if(f[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    f[i][j] = true;
                    if(max < j-i+1){
                        max = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

        String res = s.longestPalindrome("bbcc");
        System.out.print(res);
    }
}
