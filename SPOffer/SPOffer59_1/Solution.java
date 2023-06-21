package SPOffer.SPOffer59_1;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    // 方法1 ： 优先队列
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1,int[] o2 ){
//                return o2[0] - o1[0];
//            }
//        });
//        for (int i = 0; i < k  ; i++) {
//            pq.add(new int[]{nums[i],i});
//        }
//        int n = nums.length;
//        if(k == 1) return nums;
//        int[] ans = new int[n-k+1];
//        ans[0] = pq.peek()[0];
//        for (int i = 0; i < n-k; i++) {
//            pq.add(new int[]{nums[i+k], i+k});
//            while (pq.peek()[1] <= i){
//                pq.poll();
//            }
//            ans[i+1] = pq.peek()[0];
//        }
//        return ans;
//    }


    // 方法2： 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new LinkedList<>();
        int n = nums.length;
        if(k == 1) return nums;
        int[] ans = new int[n-k+1];
        for (int i = 0; i <= n; i++) {
            if(i >= k){
                while(dq.peek()[1] < i - k) dq.poll();
                ans[i-k] = dq.peek()[0];
            }
            if(i != n){
                while(!dq.isEmpty() && dq.peekLast()[0] <= nums[i]){
                    dq.pollLast();
                }
                dq.offer(new int[]{nums[i],i});
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7} , 3);
    }
}
