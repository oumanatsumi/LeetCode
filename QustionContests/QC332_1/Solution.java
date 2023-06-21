package QustionContests.QC332_1;

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0,right = nums.length-1;
        long res = 0L;
        while(left < right){
            res += Integer.parseInt(String.valueOf(nums[left]) + String.valueOf(nums[right]));
            left ++;
            right --;
        }
        if(left == right){
            res += nums[left];
        }
        return res;
    }
}
