package Q2485;

public class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        for (int i = 1; i < n; i++) {
            int l = (1 + i) *i /2;
            int r = (i + n) *(n - i +1)/2;
            if(l == r) return i;
        }
        return -1;
    }
}
