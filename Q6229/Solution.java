package Q6229;

class Solution {
    public int[] applyOperations(int[] nums) {
        int [] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]){
                nums[i-1] = 2 *nums[i-1];
                nums[i] = 0;
            }
        }
        int zeroCnt = 0;
        for(int i:nums){
            if(i == 0) zeroCnt++;
        }

        int index  =0 ;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                res[index] = nums[i];
                index++;
            }
        }
        for(int i =index;i<nums.length;i++){
            res[i] = 0 ;
        }
        return res;
    }
}
