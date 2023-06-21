package Q1906;

import java.util.Arrays;
import java.util.Map;

class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] sum = new int[n][101];
        sum[0][nums[0]]++;
        for (int i = 1; i < n; i++) {
            sum[i] = Arrays.copyOf(sum[i-1],101);
            sum[i][nums[i]]++;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int l = queries[i][0],r = queries[i][1];
            int[] tempSortList = new int[101];
            if(l == 0) tempSortList = sum[r];
            else {
                for (int j = 0; j < sum[l].length; j++) {
                    tempSortList[j] = sum[r][j] - sum[l-1][j];
                }
            }
            int minDis = 100, lastIndex = -100;
            for (int j = 0; j < sum[l].length; j++) {
                if(tempSortList[j] == 0) continue;
                minDis = Math.min(minDis, j - lastIndex);
                lastIndex = j;
            }
            if(minDis == 100) ans[i] = -1;
            else ans[i] = minDis;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minDifference(new int[]{5,2,4,7,2},new int[][]{{0,2},{1,3}});
    }
}
