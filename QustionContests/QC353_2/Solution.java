package QustionContests.QC353_2;


class Solution {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if(dp[j]!= -1 && Math.abs(nums[j] - nums[i]) <= target){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max == Integer.MIN_VALUE ? -1 : max;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumJumps(new int[]{1,2}, 2));
    }
}
