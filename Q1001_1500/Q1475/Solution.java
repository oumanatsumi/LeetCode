package Q1001_1500.Q1475;

import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack= new Stack<>();
        int[] ans = new int[prices.length];
        for(int i = prices.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = prices[i];
            }else {
                ans[i] = prices[i] - stack.peek();
            }
            stack.push(prices[i]);
        }
        return ans;
    }
}
