package QC342_3;

public class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] map = new int[101];
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            map[nums[i]+50]++;
        }
        int tx = x;
        for (int i = 0; i <101 ; i++) {
            if(map[i] > 0){
                tx -= map[i];
                if(tx <= 0) {
                    ans[0] = Math.min(i-50, 0);
                    break;
                }
            }
        }
        for (int i = k ; i < n; i++) {
            map[nums[i]+50]++;
            map[nums[i-k]+50]--;
            tx = x;
            for (int j = 0; j < 101; j++) {
                if(map[j] > 0){
                    tx -= map[j];
                    if(tx <= 0) {
                        ans[i-k+1] = Math.min(j-50, 0);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getSubarrayBeauty(new int[]{-1,-2,-3,-4,-5},2,2);
    }
}
