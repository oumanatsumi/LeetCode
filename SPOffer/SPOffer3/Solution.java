package SPOffer.SPOffer3;

class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i =0;i<nums.length;i++){
            while (nums[i] != i){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return 0;
    }
}
