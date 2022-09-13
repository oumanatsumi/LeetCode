package Q6176;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            if(i%2==0){
                map.put(i, map.getOrDefault(i,0)+1);
            }
        }
        int max = 0;
        int ans = 0;
        for(int i: map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
                ans = i;
            }else if(map.get(i) == max){
                ans = Math.min(ans , i);
            }
        }
        if(max ==0 ) return -1;
        return ans;
    }
}
