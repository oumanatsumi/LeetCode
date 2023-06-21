package Q2481;

class Solution {
    public int numberOfCuts(int n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return n/2;
        else return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numberOfCuts(14);
    }
}
