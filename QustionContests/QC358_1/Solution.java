package QustionContests.QC358_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int maxSum(int[] nums) {
        List<List<Integer>> ns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ns.add(new ArrayList<>());
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = nums[i];
            int max = 0;
            while (tmp >0){
                max = Math.max(max, tmp %10);
                tmp /= 10;
            }
            ns.get(max).add(nums[i]);
        }
        int maxSum = -1;
        for (int i = 0; i < 10; i++) {
            if(ns.get(i).size() > 1){
                Collections.sort(ns.get(i), new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
                maxSum = Math.max(maxSum, ns.get(i).get(0) + ns.get(i).get(1));
            }
        }
        return maxSum;
    }
}
