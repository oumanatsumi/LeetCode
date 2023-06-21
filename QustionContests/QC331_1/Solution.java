package QustionContests.QC331_1;

import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
        for(int gift: gifts){
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int temp = pq.poll();
            int t2 = (int) Math.sqrt(temp);
            pq.offer(t2);
        }
        long res = 0;
        while (!pq.isEmpty()){
           res += pq.poll();
        }
        return res;
    }
}
