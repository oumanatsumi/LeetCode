package Q1001_1500.Q1464;

class Solution {
    public int maxProduct(int[] nums) {
        int max = -1,second = -2;
        for(int i:nums){
            if(i > max){
                second = max;
                max = i;
            }
            else if(i>second){
                second = i;
            }
        }
        return (max-1)*(second-1);
    }
}
