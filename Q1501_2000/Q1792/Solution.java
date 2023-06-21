package Q1501_2000.Q1792;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = (o2[1] - o2[0]) * (o1[1]+1) * o1[1];
                int v2 = (o1[1] - o1[0]) * (o2[1]+1) * o2[1];
                if(v1 == v2) return 0;
                return v1 > v2 ? 1 : -1;
            }
        });
        pq.addAll(Arrays.asList(classes));
        for (int i = 0; i < extraStudents; i++) {
            int[] select = pq.poll();
            pq.add(new int[]{select[0] +1, select[1] +1});
        }

        double ans = 0;
        while(!pq.isEmpty()){
            int[] output = pq.poll();
            ans += (double) output[0]/output[1];
        }
        return ans / classes.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2);
    }
}
