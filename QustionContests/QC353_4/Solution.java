package QustionContests.QC353_4;

class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] d = new int[n+1];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            d[i] = nums[i] - nums[i-1];
        }
        d[n] = -nums[n-1];
        for (int i = 0; i <= n-k; i++) {
            if(d[i] > 0){
                d[i+k] += d[i];
                d[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if(d[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkArray(new int[]{2,2,3,2,2,1}, 3));
    }
}
