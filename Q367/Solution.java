package Q367;

class Solution {
    public boolean isPerfectSquare(int num) {
        return (int)Math.sqrt(num)*(int)Math.sqrt(num)==num;
    }

    public static void main(String [] args)
    {
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(14));
    }

}
