package QC340_3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                pq.add(Math.abs(nums[i]-nums[j]));
            }
        }
        for (int i = 1; i < p; i++) {
            pq.poll();
        }
        return p == 0 ? 0:pq.peek();
    }
}
