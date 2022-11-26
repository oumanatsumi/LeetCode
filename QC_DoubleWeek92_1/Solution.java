package QC_DoubleWeek92_1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numberOfCuts(int n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return n/2;
        else return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numberOfCuts(14);
    }
}
