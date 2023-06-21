package SPOffer41;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> pqLow;
    PriorityQueue<Integer> pqHigh;
    int lowCnt = 0;
    int highCnt = 0;
    public MedianFinder() {
        pqLow = new PriorityQueue<>(((o1, o2) -> {
            return o2-o1;
        }));
        pqHigh = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(pqLow.isEmpty()) {
            pqLow.add(num);
            lowCnt++;
        }
        else {
            if(pqLow.peek() > num){
                pqLow.add(num);
                lowCnt++;
            }else {
                pqHigh.add(num);
                highCnt++;
            }
            if(lowCnt - highCnt > 1) {
                pqHigh.add(pqLow.poll());
                lowCnt--;
                highCnt++;
            }
            else if(lowCnt < highCnt) {
                pqLow.add(pqHigh.poll());
                highCnt--;
                lowCnt++;
            }
        }
    }

    public double findMedian() {
        if(lowCnt == highCnt){
            return  (pqHigh.peek()+pqLow.peek())/2.0f;
        }else {
            return (double)pqLow.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        medianFinder.addNum(-5);
        double d = medianFinder.findMedian();
        System.out.println(d);
    }
}
