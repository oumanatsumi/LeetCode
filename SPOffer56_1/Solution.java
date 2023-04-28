package SPOffer56_1;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int xny = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            xny ^= nums[i];
        }
        int m = 1;
        while((xny & m) == 0){
            m <<= 1;
        }
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if((nums[i] & m) == 0){
                ans[0] ^= nums[i];
            }else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.singleNumbers(new int[]{
                31,79,44,47,26,38,83,18,65,67,97,88,94,82,11,46,92,15,74,5,21,85,74,
                58,73,87,17,29,96,82,94,56,13,68,27,15,83,85,11,41,27,58,39,93,46,70,5,44,92
                ,4,42,90,71,18,96,90,88,72,62,30,65,31,9,28,87,47,62,71,41,39,4,26,97,84,70,
                59,56,73,1,13,9,67,52,42,79,72,38,68,29,40,28,84,30,40,17,21,52,93
        });
    }
}
