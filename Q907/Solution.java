package Q907;

import java.util.Deque;
import java.util.LinkedList;



class Solution {
    private static final int mod = 1000000007;
    /**
     * 单调栈解法
     */
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.peek()] >= arr[i]){
                int topIndex = dq.poll();
                ans += (long) (i - topIndex) *(dq.isEmpty()? (topIndex+1) : (topIndex - dq.peek()))*arr[topIndex];
            }
            dq.push(i);
        }
        while (!dq.isEmpty()){
            int topIndex = dq.poll();
            ans += (long) (n - topIndex) *(dq.isEmpty()? (topIndex+1) : (topIndex - dq.peek()))*arr[topIndex];
        }
        return (int) (ans % mod);
    }
}
