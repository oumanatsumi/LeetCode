package SPOffer10_1;

public class Solution {
    public int fib(int n) {
        // Timeout
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        return (fib(n-2)+fib(n-1)) % 1000000007;
        int[] map = new int[101];
        map[0] = 0;
        map[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            map[i] = (map[i-1]+ map[i-2]) % 1000000007;
        }
        return map[n];
    }
}
