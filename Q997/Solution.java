package Q997;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0)
        {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] person = new boolean[n+1];
        for(int[] t : trust)
        {
            person[t[0]] = true;
            map.put(t[1],map.getOrDefault(t[1],0)+1);
        }
        int judge =0;
        for(int i=1;i<=n;i++)
        {
            if(!person[i])
            {
                if(judge ==0)
                {
                    judge = i;
                }
                else
                {
                    return -1;
                }
            }
        }
        if(map.containsKey(judge) && map.get(judge)==n-1)
        {
            return judge;
        }
        else
        {
            return -1;
        }
    }
}
