package Q1710;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[1] - o2[1];
            }
        });
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if(boxTypes[i][0] >= truckSize){
                res += truckSize* boxTypes[i][1];
                break;
            }else {
                res += boxTypes[i][0]*boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
        }
        return res;
    }
}
