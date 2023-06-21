package Q1501_2000.Q1619;

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int deleteLength = (int)(arr.length * 0.05);
        int total = 0;
        for(int i = deleteLength;i<arr.length-deleteLength;i++){
            total += arr[i];
        }
        return (double)total/(double) (arr.length-2*deleteLength);
    }
}
