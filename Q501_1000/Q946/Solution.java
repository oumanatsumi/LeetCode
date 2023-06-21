package Q501_1000.Q946;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int indexPushed = 0;
        int indexPoped = 0;
        while (indexPoped < popped.length){
            if(stack.contains(popped[indexPoped])){
                if(stack.peek()!=popped[indexPoped]){
                    return false;
                }
                else {
                    stack.pop();
                    indexPoped ++;
                }
            }
            else {
                if(indexPushed >= pushed.length)
                {
                    return false;
                }
                else {
                    stack.push(pushed[indexPushed]);
                    indexPushed++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,1,2};
        System.out.println(s.validateStackSequences(pushed,poped));
    }
}
