package Q1_500.Q215;

class Solution {
    public int res = -1;
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];
        partition(nums, 0, n-1, n-k);
        return res == -1 ? nums[n-k] : res;
    }

    private void partition(int[] nums, int l, int r, int k){
        if(l>=r || res != -1) return;
        int i = l, j = r, sentinel = nums[i];
        while (i < j){
            while(i < j && nums[j] >= sentinel) j--;
            if(i < j) nums[i] = nums[j];
            while (i < j && nums[i] <= sentinel) i++;
            if(i < j) nums[j] = nums[i];
        }
        nums[i] = sentinel;
        if(i == k){
            res = nums[i];
        }else if(i > k){
            partition(nums, l, i-1, k);
        }else {
            partition(nums, i+1, r, k);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 1};
        int res = s.findKthLargest(nums, 2);
        System.out.println(res);
    }
}
