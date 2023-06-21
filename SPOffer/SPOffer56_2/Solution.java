package SPOffer.SPOffer56_2;

class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if((nums[i] & (1 << j)) != 0){
                    bit[j] ++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += bit[i] % 3 == 1 ? (1 << i) : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.singleNumber(new int[]{3,4,3,3});
    }

}
