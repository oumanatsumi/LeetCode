package Q1_500.Q371;

class Solution {
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int carry = (a&b)<<1;
            a= a^b;
            b=carry;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

        int res = s.getSum(2,3);
        System.out.print(res);
    }
}
