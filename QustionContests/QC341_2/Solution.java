package QustionContests.QC341_2;

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int n = divisors.length;
        int m = nums.length;
        int max = 0,maxIndex = 0,minRet = divisors[0];
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                if(nums[j] % divisors[i] == 0)
                {
                    tmp ++;
                }
            }
            if(max < tmp){
                max = tmp;
                maxIndex = i;
                minRet = divisors[maxIndex] ;
            }else if(max == tmp && minRet > divisors[i]){
                maxIndex = i;
                minRet = divisors[maxIndex] ;
            }
        }
       return minRet;
    }
}
