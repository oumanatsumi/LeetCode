package SPOffer53;

public class Solution {
    public int missingNumber(int[] nums) {
        for(int i =0;i<nums.length;i++){
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
}
