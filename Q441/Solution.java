package LeetCode.Q441;

public class Solution {


    //超时了
//    public int arrangeCoins(int n) {
//
//        for(int i=0;i<=n;i++)
//        {
//            int temp = (1+i)*i/2;
//            int temp2=(2+i)*(i+1)/2;
//            if(temp == n || (n>temp && n<temp2))
//            {
//                return i;
//            }
//        }
//        return 0;
//    }


//

    public int arrangeCoins(int n) {
        return (int)(Math.sqrt((long)8*n+1)-1)/2;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int res = s.arrangeCoins(1804289383);
        System.out.println(res);
    }
}
