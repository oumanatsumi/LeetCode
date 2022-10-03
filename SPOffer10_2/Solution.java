package SPOffer10_2;

public class Solution {
    public int numWays(int n) {
        if(n < 2) return 1;
        int a =1,b=1,c = 0;
        for(int i = 2; i<=n ;i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
