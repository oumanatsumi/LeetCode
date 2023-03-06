package QC_DoubleWeek99_2;

public class Solution {
    public long coloredCells(int n) {
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = res + 4*i;
        }
        return res;
    }
}
