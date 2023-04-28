package SPOffer59_2;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> deque = new LinkedList<>();
    Deque<Integer> singleDeque = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return singleDeque.peekLast();
    }

    public void push_back(int value) {
        deque.push(value);
        while(!singleDeque.isEmpty() && singleDeque.peek() < value){
            singleDeque.poll();
        }
        singleDeque.push(value);

    }

    public int pop_front() {
        if(deque.isEmpty()) return -1;
        if(deque.peekLast().equals(singleDeque.peekLast())) singleDeque.pollLast();
        return deque.pollLast();
    }
}
