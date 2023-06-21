package Q501_1000.Q646;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int cur = Integer.MIN_VALUE,cnt = 0;
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        for(int[] a:pairs){
            if(a[0] > cur){
                cur = a[1];
                cnt++;
            }
        }
        return cnt;
    }
}
