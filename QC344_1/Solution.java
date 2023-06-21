package QC344_1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            pre[i] = set.size();
        }
        set.clear();
        for (int i = n-1; i >= 0; i--) {
            pre[i] -= set.size();
            set.add(nums[i]);
        }
        return pre;
    }
}
