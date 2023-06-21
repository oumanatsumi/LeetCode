package Q6189;

import java.util.Map;

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxInt = nums[0];
        int curInt = nums[0];
        int startIndex = 0;
        int maxLength = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i] > maxInt){
                startIndex = i;
                curInt = nums[i];
                maxInt = curInt;
                maxLength = 0;
            }
            curInt = curInt & nums[i];
            if(curInt < maxInt){
                startIndex = i;
                curInt = nums[i];
            }else if(curInt >maxInt){
                maxInt = curInt;
                startIndex = i;
            }else {
                maxLength = Math.max(maxLength, (i- startIndex));
            }
        }
        return maxLength+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.longestSubarray(new int[]{1,2,3,4});
        System.out.println(res);
    }
}
