package QustionContests.QC333_2;

class Solution {
    public int minOperations(int n) {
        int step = 0;
        while(n != 0){
            int lb = lowbit(n);
            if(lowbit(n + lb) == lb * 2){
                n -= lb;
            }else {
                n += lb;
            }
            step++;
        }
        return step;
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(39));
    }
}
