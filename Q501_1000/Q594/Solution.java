package Q501_1000.Q594;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n :nums
             ) {
            if(map.containsKey(n))
            {
                map.put(n,map.get(n)+1);
            }
            else
            {
                map.put(n,1);
            }
        }

        int max = 0;
        for(Integer key:map.keySet())
        {
            if(map.keySet().contains(key-1))
            {
                max = Math.max(map.get(key - 1) + map.get(key), max);
            }
        }
        return max;
    }
}
