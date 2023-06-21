package Q6178;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int[] interval: intervals){
            if(priorityQueue.isEmpty()){
                priorityQueue.offer(interval[1]);
            }else {
                if(priorityQueue.peek() >= interval[0]){
                    priorityQueue.offer(interval[1]);
                }else {
                    priorityQueue.poll();
                    priorityQueue.offer(interval[1]);
                }
            }
        }

        return priorityQueue.size();
    }
}
