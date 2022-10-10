package SPOffer14_2;

public class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n-1;
        if(n % 3 == 0) return quickMod(3,n /3);
        else if(n % 3 == 1) {
            long modRes = quickMod(3, n /3 -1)  * 4L % 1000000007;
            return (int)modRes;
        }
        else{
            long modRes = quickMod(3,n/3) * 2L % 1000000007;
            return (int)modRes;
        }
    }

    private int quickMod(long a, int b){
        long res = 1;
        while (b>0){
            if((b & 1) == 1){
                res = (res * a) % 1000000007;
            }
            a = (a * a) % 1000000007;
            b = b / 2;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.cuttingRope(127);
        System.out.println(res);
    }
}
