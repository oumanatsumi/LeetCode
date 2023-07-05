package Q2001_2500.Q2475;

class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i] == nums[j]) continue;
                for (int k = j+1; k < n; k++) {
                    if(nums[i]!= nums[k] && nums[i] != nums[k]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
