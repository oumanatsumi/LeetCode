package SPOffer53;

public class Solution {
    // 暴力
    public int search(int[] nums, int target) {
        int ans = 0;
        for(int i:nums){
            if(target<i){
                return ans;
            }else if(target == i){
                ans++;
            }
        }
        return ans;
    }


}
