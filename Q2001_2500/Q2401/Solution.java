package Q2001_2500.Q2401;

class Solution {

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        for(int i =0;i<nums.length-1;i++){
            int j = i+1;
            int temp = nums[i];
            while(j< nums.length){
                if((nums[j] & temp) == 0){
                    temp |= nums[j];
                    j++;
                }else {
                    break;
                }
            }
            max = Math.max(j-i, max);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestNiceSubarray(new int[]{135745088,609245787,16,2048,2097152}));

    }
}
