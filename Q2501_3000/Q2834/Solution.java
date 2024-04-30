package Q2501_3000.Q2834;

import java.util.*;

class Solution {
    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet<>();
        if(n == 1) return 1;
        set.add(1);
        long sum = 1;
        int index = 2;
        for (int i = 1; i < n; i++) {
            while (set.contains(target - index)){
                index ++;
            }
            sum += index;
            set.add(index);
            index++;
        }
        return sum;
    }
}
