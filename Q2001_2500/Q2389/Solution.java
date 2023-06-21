package Q2001_2500.Q2389;

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = n;
            for (int j = 0; j < n; j++) {
                if(queries[i] < prefix[j]){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
