package Q501_1000.Q878;

class Solution {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = lcm(a, b);
        long l = Math.min(a, b);
        long r = (long)n * Math.min(a, b);
        while (l < r){
            long mid = (l + r) >>> 1;
            long cnt = (mid / a) + (mid / b) - (mid / c);
            if(cnt >= n){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
