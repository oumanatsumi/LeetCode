package SPOffer.SPOffer53;

class Solution {
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
