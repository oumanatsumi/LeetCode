package SPOffer30;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> assistStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(assistStack.isEmpty()){
            assistStack.push(x);
        }
        else {
            if(assistStack.peek() < x){
                assistStack.push(assistStack.peek());
            }else {
                assistStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        assistStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return assistStack.peek();
    }
}