package Q501_1000.Q739;


import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        int index;
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                index = stack.poll();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            ans[stack.poll()] = 0;
        }
        return ans;
    }
}
