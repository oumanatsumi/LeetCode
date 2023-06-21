package QC345_1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] win = new boolean[n];
        int cur = 0,  round = 1;
        win[0] = true;
        while (true){
            cur = (cur + round * k) % n;
            if(win[cur]) break;
            win[cur] = true;
            round ++;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!win[i]) resList.add(i);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i)+1;
        }
        return res;
    }
}