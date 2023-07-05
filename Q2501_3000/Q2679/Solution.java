package Q2501_3000.Q2679;

import java.util.PriorityQueue;

class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        PriorityQueue[] pqs = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            pqs[i] = new PriorityQueue<Integer>();
            for(int num : nums[i]){
                pqs[i].add(num);
            }
        }
        int score = 0, max;
        for (int i = 0; i < nums[0].length; i++) {
            max = -1;
            for (int j = 0; j < n; j++) {
                max = Math.max((int) pqs[j].poll(), max);
            }
            score += max;
        }
        return score;
    }
}
