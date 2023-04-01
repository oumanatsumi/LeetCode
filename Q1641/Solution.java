package Q1641;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
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
