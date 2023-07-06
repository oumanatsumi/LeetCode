package Q2001_2500.Q2178;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 == 1) return new ArrayList<>();
        long lastNum = (long) Math.ceil(Math.sqrt(4 * finalSum + 1) - 1);
        if(lastNum % 2 == 1) lastNum++;
        long lostNum = (2 + lastNum) * lastNum / 4 - finalSum;
        List<Long> res = new ArrayList<>();
        for (long i = 2; i <= lastNum ; i+= 2) {
            if(i!= lostNum) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumEvenSplit(28);
    }
}
