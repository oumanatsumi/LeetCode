package QustionContests.QC359_2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumSum(int n, int k) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int index = 1;
        while (set.size() < n){
            if(!set.contains(k-index)){
                set.add(index);
                sum+=index;
            }
            index++;
        }
        return sum;
    }
}
