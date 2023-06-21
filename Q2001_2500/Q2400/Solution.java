package Q2001_2500.Q2400;

import java.math.BigInteger;

class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int left = 0,right =0;
        int dirc = endPos - startPos;
        if(dirc > 0){
            right += Math.abs(dirc);
        }else {
            left += Math.abs(dirc);
        }
        if(k < Math.abs(dirc) || (k -Math.abs(dirc))%2 ==1){
            return 0;
        }else if(k == Math.abs(dirc)){
            return 1;
        }
        else{
            left +=(k -Math.abs(dirc))/2;
            right+=(k -Math.abs(dirc))/2;
        }

        return (int)C((long)k,(long)left);
    }

    public static long C(long n,long m) {
//        //分子
//        long son = 1;
//        //分母
//        long mother = 1;
//        // 应用组合数的互补率简化计算量
//        m = m > (n - m) ? (n - m) : m;
//        for(long i = m;i > 0; i--) {
//            //如果你还记得上面的求全排列数的实现，你应该会发现 son 就是在求 A(n，m)
//            son = son * n ;
//            mother = mother * i ;
//            n--;
//        }
//        return (son / mother)%1000000007;
        //分子
        BigInteger son = new BigInteger("1");
        //分母
        BigInteger mother = new BigInteger("1");
        // 应用组合数的互补率简化计算量
        m = m > (n - m) ? (n - m) : m;
        for(long i = m;i > 0; i--) {
            //如果你还记得上面的求全排列数的实现，你应该会发现 son 就是在求 A(n，m)
            son = son.multiply(BigInteger.valueOf(n));
            mother = mother.multiply(BigInteger.valueOf(i));
            n--;
        }
        long modRes = son.divide(mother).mod(BigInteger.valueOf(1000000007)).longValue();
        return modRes;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.numberOfWays(2,100 ,1000);
        System.out.println(res);
    }
}
