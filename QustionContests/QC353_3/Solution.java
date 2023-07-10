package QustionContests.QC353_3;

class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // dp[i][0] 表示，i结尾的最长非递减子数组的长度，且选择的是nums1的数字，dp[i][1]同理
        int[][] dp = new int[n][2];
        // 边界
        dp[0][0] = 1;
        dp[0][1] = 1;
        int tmp1,tmp2;
        for (int i = 1; i < n; i++) {
            tmp1 = 1;
            tmp2 = 1;
            if(nums1[i] >= nums1[i-1]){
                tmp1 = dp[i-1][0] + 1;
            }
            if(nums1[i] >= nums2[i-1]){
                tmp2 = dp[i-1][1] + 1;
            }
            dp[i][0] = Math.max(tmp1,tmp2);
            tmp1 = 1;
            tmp2 = 1;
            if(nums2[i] >= nums1[i-1]){
                tmp1 = dp[i-1][0] + 1;
            }
            if(nums2[i] >= nums2[i-1]){
                tmp2 = dp[i-1][1] + 1;
            }
            dp[i][1] = Math.max(tmp1,tmp2);
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxNonDecreasingLength(
                new int[]{8,15,14,13,19},
                new int[]{18,8,5,4,10}));

    }
}
