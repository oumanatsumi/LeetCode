package Q2001_2500.Q2439;

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i:nums){
            max = Math.max(i,max);
        }
        int left = 0,right = max;
        while(left <= right){
            int mid = (left + right) >>> 1;
            long tmp = 0;
            for (int i = n-1; i >=0 ; i--) {
                tmp = Math.max(0, tmp + nums[i] - mid);
            }
            if(tmp > 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimizeArrayValue(new int[]{3,7,1,6});
    }
}
