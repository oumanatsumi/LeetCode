package SPOffer39;

public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0],count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == res){
                count++;
            }else {
                if(count == 0){
                    res = nums[i];
                    count = 1;
                }else {
                    count--;
                }
            }
        }
        return res;
    }
}
