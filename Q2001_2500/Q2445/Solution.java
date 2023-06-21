package Q2001_2500.Q2445;

class Solution {
    public int averageValue(int[] nums) {
        int sum = 0,cnt = 0;
        for(int i :nums){
            if(i%6==0){
                cnt++;
                sum += i;
            }
        }
        return cnt == 0 ? 0:sum/cnt;
    }
}
