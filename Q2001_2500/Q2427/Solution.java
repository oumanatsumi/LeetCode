package Q2001_2500.Q2427;

class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if(a%i == 0 && b % i ==0){
                ans ++;
            }
        }
        return ans;
    }
}
