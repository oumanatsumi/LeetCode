package Q2501_3000.Q2530;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> A=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO 自动生成的方法存根
                return o2-o1;
            }
        });
        for(int i :nums){
            A.offer(i);
        }
        long score = 0;
        for (int i = 0; i < k; i++) {
            score += A.peek();
            int temp = A.poll();
            A.offer((int) Math.ceil(temp / 3.0));
        }
        return score;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxKelements(new int[]{1,10,3,3,3},3);
    }
}
