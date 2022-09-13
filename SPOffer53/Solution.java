package SPOffer53;

public class Solution {
    // 暴力
//    public int search(int[] nums, int target) {
//        int ans = 0;
//        for(int i:nums){
//            if(target<i){
//                return ans;
//            }else if(target == i){
//                ans++;
//            }
//        }
//        return ans;
//    }

    // 二分
    public int search(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int ans = 0;
        while(left<right){
            int mid = (left + right)/2;
            if(target == mid){
                ans ++;
            }
        }
    }
}
