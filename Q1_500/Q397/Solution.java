package Q1_500.Q397;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n*1L);
    }

    private int dfs(Long n)
    {
        if(n==1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int ans =0;
        if(n%2==0)
        {
            ans = dfs(n/2);
        }
        else
        {
            ans = Math.min(dfs(n+1),dfs(n-1));
        }
        map.put(n,++ans);
        return ans;
    }

}
