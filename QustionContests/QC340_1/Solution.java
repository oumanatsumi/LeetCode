package QustionContests.QC340_1;

class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j || i == n-j-1){
                    if(check(nums[i][j])){
                        max = Math.max(max , nums[i][j]);
                    }
                }
            }
        }
        return max == 1 ? 0 : max ;
    }

    private boolean check(int num){
        int lim = (int) Math.sqrt(num);
        for (int i = 2; i <= lim; i++) {
            if(num % i == 0)  return false;
        }
        return true;
    }
}
