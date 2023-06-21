package Q268;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1+nums.length)*nums.length/2;
        for(int num:nums)
        {
            sum = sum - num;
        }
        return sum;
    }
}
