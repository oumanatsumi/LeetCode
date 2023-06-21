package Q862;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n+1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        Deque<Integer> dq = new LinkedList<>(); // 存放下标的单调队列
        int ans = n+1;
        for (int i = 0; i <= n; i++) {
            long curSum = sum[i];
            // condition 1
            while (!dq.isEmpty() && curSum - sum[dq.peekFirst()]>=k) {
                ans = Math.min(ans,i - dq.peekFirst());
                dq.pollFirst();
            }
            // condition 2
            while (!dq.isEmpty() && curSum <= sum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return ans > n ? -1 : ans;
    }
}
