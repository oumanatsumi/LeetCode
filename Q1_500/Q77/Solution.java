package Q1_500.Q77;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<Integer> cur, int stat){
        if(cur.size() == k){
            if(!set.contains(stat)){
                res.add(new ArrayList<>(cur));
                set.add(stat);
            }
            return;
        }
        for (int i = 1; i < n; i++) {
            if((stat & (1 << i)) != 1){
                cur.add(i);
                dfs(cur, stat |= (1<< i));
                cur.remove(cur.size()-1);
            }
        }
    }
}
