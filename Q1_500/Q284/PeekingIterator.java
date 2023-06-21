package Q1_500.Q284;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.nextElement = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = nextElement;
        if(iterator.hasNext())
        {
            nextElement = iterator.next();
        }
        else
        {
            nextElement = null;
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }



}
