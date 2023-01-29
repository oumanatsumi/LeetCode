package Q6338;

public class Solution {
    public int monkeyMove(int n) {
        int MOD = 1000000007;
        long res = quickMod(2,n,MOD);
        return (int) (res > 0 ? res : MOD + res);
    }


    long quickMod(long a, long b, int c) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1)
                ans = (ans * a) % c;
            b /= 2;
            a = (a * a) % c;
        }
        return ans-2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.monkeyMove(500000003);
    }
}
