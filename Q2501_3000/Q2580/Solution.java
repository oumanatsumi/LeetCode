package Q2501_3000.Q2580;

class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;
        if(n == 1) return nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int l = min, r = max,mid;
        while (l <= r){
            mid = (l + r) >>> 1;
            if(check(nums, k ,mid)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int k, int max){
        int n1 = nums[0] <= max ? 1 : 0;
        int n2 = Math.min(nums[0],nums[1]) <= max ? 1 : 0;
        int tmp = 0;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] <= max){
                tmp = Math.max(n2, n1 +1);
            }else {
                tmp = n2;
            }
            n1 = n2;
            n2 = tmp;
            if(n2 >= k) return true;
        }
        return n2 >= k;
    }
}