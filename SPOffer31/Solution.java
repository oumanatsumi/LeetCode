package SPOffer31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        while(popIndex < n){
            if(!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }else if(pushIndex < n){
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }else {
                return false;
            }
        }
        return true;
    }
}
