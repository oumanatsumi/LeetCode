package Q2501_3000.Q2529;

class Solution {
    public int maximumCount(int[] nums) {
        int posCnt = 0, negCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0) negCnt++;
            else if(nums[i] >0) posCnt++;
        }
        return Math.max(posCnt,negCnt);
    }
}
