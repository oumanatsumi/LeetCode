package SPOffer.SPOffer49;

class Solution {
    /**
     * 最小堆算法
     * @param n
     * @return
     */
//    public int nthUglyNumber(int n) {
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        Set<Long> set = new HashSet<>();
//        pq.offer(1L);
//        while(n > 1){
//            long cur = pq.poll();
//            n--;
//            if(set.add(cur * 2)) pq.offer(cur * 2);
//            if(set.add(cur * 3)) pq.offer(cur * 3);
//            if(set.add(cur * 5)) pq.offer(cur * 5);
//        }
//        return pq.peek().intValue();
//    }

    /**
     * 动态规划做法
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0 ,c = 0;
        for (int i = 1; i < n; i++) {
            int next = Math.min(Math.min(dp[a]*2, dp[b]*3),dp[c] * 5);
            dp[i] = next;
            if(next == dp[a] *2) a++;
            if(next == dp[b] *3) b++;
            if(next == dp[c] *5) c++;
        }
        return dp[n-1];
    }
}
