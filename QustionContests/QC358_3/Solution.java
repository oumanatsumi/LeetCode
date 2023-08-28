package QustionContests.QC358_3;

import java.util.List;
import java.util.TreeSet;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if(x == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        treeSet.add(Integer.MAX_VALUE);
        treeSet.add(Integer.MIN_VALUE /2);
        for (int i = 0; i < nums.size()-x; i++) {
            treeSet.add(nums.get(i));
            int nextInt = nums.get(i+x);
            min = Math.min(min, Math.min(Math.abs(nextInt - treeSet.ceiling(nextInt)), Math.abs(treeSet.floor(nextInt)-nextInt)));
        }
        return min;
    }
}
