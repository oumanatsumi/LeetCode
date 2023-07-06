package Q1501_2000.Q1658;

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if(n == 1) return nums[0] == x ? 1 : -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        sum -= x;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        int l = 0, r = 0, tmp = nums[0];
        int maxSize = -1;
        while (l< n && r < n){
            if(tmp == sum) {
                maxSize = Math.max(maxSize, r - l + 1);
                r++;
                if(r < n)  tmp += nums[r];
            }
            else if(tmp > sum) {
                tmp -= nums[l++];
            }
            else {
                r++;
                if(r < n)  tmp += nums[r];
            }
        }
        return maxSize == -1 ? -1 : n-maxSize;
    }
}
