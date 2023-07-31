package Q1_500.Q42;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
//    public int trap(int[] height) {
//        int res = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        stack.add(0);
//        for (int i = 1; i < height.length; i++) {
//            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
//                int bottom = stack.poll();
//                if(stack.isEmpty()){
//                    break;
//                }
//                int left = stack.peek();
//                res += (i - left - 1)*(Math.min(height[i], height[left])- height[bottom]);
//            }
//            stack.push(i);
//        }
//        return res;
//    }


    public int trap(int[] height) {
        int res = 0,n = height.length;
        if(n < 3) return 0;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int leftMax = height[0];
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            int lowWall = Math.min(leftMax,rightMax[i]);
            if(lowWall > height[i]){
                res += lowWall - height[i];
            }
        }
        return res;
    }
}
