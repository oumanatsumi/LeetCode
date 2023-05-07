package QC344_2;

import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {

    Map<Integer,Integer> map;
    Map<Integer,Integer> cntMap;
    public FrequencyTracker() {
        map = new HashMap<>();
        cntMap = new HashMap<>();
    }

    public void add(int number) {
        if(map.containsKey(number)){
            int curCnt = map.get(number);
            cntMap.put(curCnt, cntMap.get(curCnt) - 1);
            cntMap.put(curCnt+1, cntMap.getOrDefault(curCnt+1,0)+1);

            map.put(number, map.get(number)+1);
        }
        else {
            map.put(number, 1);
            cntMap.put(1, cntMap.getOrDefault(1,0)+1);
        }
    }

    public void deleteOne(int number) {
        if(map.containsKey(number) && map.get(number)!= 0){
            int curCnt = map.get(number);
            cntMap.put(curCnt, cntMap.get(curCnt) - 1);
            cntMap.put(curCnt-1, cntMap.getOrDefault(curCnt-1,0)+1);

            map.put(number, map.get(number) -1);

        }
    }

    public boolean hasFrequency(int frequency) {
        if(cntMap.containsKey(frequency) && cntMap.get(frequency)!=0) return true;
        else return false;
    }

}
