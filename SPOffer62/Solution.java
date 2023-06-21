package SPOffer62;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n ; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lastRemaining(5,3);
    }

}
