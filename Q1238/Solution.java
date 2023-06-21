package Q1238;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        for (int i = 0; i < n; i++) {
            for(int j = cur.size()-1;j >= 0;j--){
                cur.add(cur.get(j) + (1 << i));
            }
        }
        int index = cur.indexOf(start);
        List<Integer> res = new ArrayList<>();
        for (int i = index; i < cur.size() ; i++) {
            res.add(cur.get(i));
        }
        for (int i = 0; i < index ; i++) {
            res.add(cur.get(i));
        }
        return res;
    }
}
