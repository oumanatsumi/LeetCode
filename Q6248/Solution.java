package Q6248;

public class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int midIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) nums[i] = 0;
            else if (nums[i] > k) nums[i] = 1;
            else {
                nums[i] = 2;
                midIndex = i;
            }
        }
        int[][] diff = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        diff[midIndex][midIndex] = 0;
        dp[midIndex][midIndex] = 1;
        for(int i = midIndex-1; i>=0;i--){
            if(nums[i]==0){
                diff[i][midIndex]= diff[i+1][midIndex] -1;
            }else {
                diff[i][midIndex]= diff[i+1][midIndex] +1;
            }
            if(diff[i][midIndex] == 0 || diff[i][midIndex] == 1){
                dp[i][midIndex] = dp[i+1][midIndex] +1;
            }else {
                dp[i][midIndex] = dp[i+1][midIndex];
            }
        }

        for(int i = midIndex+1; i<n ; i++){
            if(nums[i]==0){
                diff[midIndex][i]= diff[midIndex][i-1] -1;
            }else {
                diff[midIndex][i]= diff[midIndex][i-1] +1;
            }
            if(diff[midIndex][i] == 0 || diff[midIndex][i] == 1){
                dp[midIndex][i] = dp[midIndex][i-1] +1;
            }else {
                dp[midIndex][i] = dp[midIndex][i-1];
            }
        }

        for (int i = midIndex -1; i >= 0 ; i--) {
            for (int j = midIndex +1; j <n ; j++) {
                if(nums[j] == 0){
                    diff[i][j] = diff[i][j-1] -1;
                }else {
                    diff[i][j] = diff[i][j-1] +1;
                }
                dp[i][j] = dp[i+1][j] +dp[i][j-1] - dp[i+1][j-1];
                if(diff[i][j] == 0 || diff[i][j] == 1){
                    dp[i][j]++;
                }
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.countSubarrays(new int[]{3,2,1,4,5}, 4);
    }
}
