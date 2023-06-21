package Q1502;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int dis = arr[1] - arr[0];
        for(int i =2;i<arr.length;i++){
            if(arr[i] - arr[i-1] != dis) return false;
        }
        return true;
    }
}
