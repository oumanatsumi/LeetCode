package Q1604;

import java.util.*;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if(!map.containsKey(keyName[i])){
                map.put(keyName[i],new ArrayList<>());
            }
            map.get(keyName[i]).add(changeToMinutes(keyTime[i]));
        }
        List<String> res = new ArrayList<>();
        for(String name: map.keySet()){
            List<Integer> times = map.get(name);
            if(times.size() < 3) continue;
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if(times.get(i) - times.get(i-2) >= 0 && times.get(i) - times.get(i-2) <= 60){
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    int changeToMinutes(String time){
        return Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3,5));
    }

}
