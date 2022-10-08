package SPOffer14_1;

public class Solution {
    public int cuttingRope(int n) {
        if(n == 2 ) return 1;
        if(n == 3 ) return 2;
        int cnt = (int) Math.sqrt((double) n);
        int base = n / cnt;
        int addCnt = n - (cnt * base);
        int res = 1;
        for (int i = 0; i < cnt - addCnt; i++) {
            res = res * base;
        }
        for (int i = 0; i < addCnt; i++) {
            res = res * (base+1);
        }
        return res;
    }
}
