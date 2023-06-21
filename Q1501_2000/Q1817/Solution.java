package Q1501_2000.Q1817;

import java.util.*;

class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] log:logs){
            if(map.containsKey(log[0])){
                map.get(log[0]).add(log[1]);
            }
            else {
                map.put(log[0],new HashSet<>());
                map.get(log[0]).add(log[1]);
            }
        }

        int[] ans = new int[k];
        for (Integer no : map.keySet()){
            ans[map.get(no).size()-1]++;
        }
        return ans;
    }
}
