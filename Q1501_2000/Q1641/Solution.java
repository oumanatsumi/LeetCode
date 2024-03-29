package Q1501_2000.Q1641;

import java.util.Arrays;

class Solution {
    public int countVowelStrings(int n) {
        int[] end = new int[5];
        Arrays.fill(end, 1);
        for (int i = 2; i <= n; i++) {
            end[1] = end[0] + end[1];
            end[2] = end[1] + end[2];
            end[3] = end[2] + end[3] ;
            end[4] = end[3] + end[4];
        }
        return end[0] + end[1] + end[2] + end[3] + end[4];
    }
}
