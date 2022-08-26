package Q1822;

public class Solution {
    public int arraySign(int[] nums) {
        int negativeCnt = 0;
        for(int i:nums){
            if(i == 0) return 0;
            if(i<0) negativeCnt++;
        }
        if(negativeCnt % 2 == 1) return -1;
        else return 1;
    }
}
