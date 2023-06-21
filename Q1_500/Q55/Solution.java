package Q1_500.Q55;

class Solution {
    public boolean canJump(int[] nums) {
        int index = nums.length-2;
        int target = nums.length-1;
        while (index > 0){
            if(nums[index] >= (target - index)){
                target = index;
            }
            index --;
        }
        return nums[0] >= target;
    }
}
