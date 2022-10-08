package SPOffer16;

public class Solution {
    public double myPow(double x, int n) {
        if(x == 1.0f || x == 0.0f) return x;
        if(x == -1.0f) {
            if(n%2 == 0) return 1.0f;
            else return -1.0f;
        }
        double res = 1.0f;
        if(n > 0){
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
        }else{
            for (int i = n; i < 0; i++) {
                res = res / x;
                if(res >=0.0 && res <0.000001f) return res;
            }
        }
        return res;
    }
}
