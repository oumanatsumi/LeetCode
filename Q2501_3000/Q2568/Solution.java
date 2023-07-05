package Q2501_3000.Q2568;

class Solution {
    public int minImpossibleOR(int[] nums) {
//        int res = nums[0], n = nums.length;
//        for(int i = 1;i<n;i++){
//            res |= nums[i];
//        }
//        String str = Integer.toBinaryString(res);
//        for (int i = str.length() - 1; i >= 0 ; i--) {
//            if(str.charAt(i) == '0'){
//                return (int)Math.pow(2.0, str.length() - i + 1);
//            }
//        }
//        return (int)Math.pow(2.0, str.length());
        boolean[] map = new boolean[31];
        for(int i : nums){
            for (int j = 0; j < 31; j++) {
                if(i == (int)Math.pow(2.0, j))
                {
                    map[j] = true;
                }
            }
        }
        for (int i = 0; i < 31; i++) {
            if(!map[i])
            {
                return (int)Math.pow(2.0, i);
            }
        }
        return (int)Math.pow(2.0, 31);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minImpossibleOR(new int[]{5,3});
        System.out.println(res);
    }
}
