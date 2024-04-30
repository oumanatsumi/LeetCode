package Q2501_3000.Q2798;

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for(int h:hours){
            if(target <= h) cnt++;
        }
        return cnt;
    }
}
