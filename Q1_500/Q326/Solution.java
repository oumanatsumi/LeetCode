package Q1_500.Q326;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0)
        {
            return false;
        }

        while(n%3==0)
        {
            n=n/3;
        }
        if(n==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.print(s.isPowerOfThree(0));
    }
}
