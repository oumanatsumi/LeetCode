package Q6167;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(s.charAt(i),i);
            }
            else {
                int dis = distance[c - 'a'];
                if(dis == i - map.get(c)-1){
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
