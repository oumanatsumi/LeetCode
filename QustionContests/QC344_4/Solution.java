package QustionContests.QC344_4;

class Solution {
    public int minIncrements(int n, int[] cost) {
        int size = (n + 1) / 2;
        int depth = 0, tmp = 1;
        while(tmp != (n+1)){
            depth++;
            tmp <<= 1;
        }
        int res = 0;
        for (int i = depth; i > 1 ; i--) {
            int begin = (1 << (i -1)) - 1;
            int len = 1 << (i - 1);
            for (int j = begin; j < begin+ len ; j+=2) {
                int max =
                res += Math.abs(cost[j] - cost[j + 1]);
                System.out.println(j + " " + (j+1));
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int res= s.minIncrements(15, new int[]{
                764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761});
        System.out.println(res);
    }
}
