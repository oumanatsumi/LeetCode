package SPOffer21;

public class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int l  = 0, r = n -1 ;
        while (l<r){
            if(nums[l] % 2 == 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;
            }else {
                l++;
            }
            if(nums[r] % 2 == 1){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }else {
                r--;
            }
        }
        return nums;
    }
}
