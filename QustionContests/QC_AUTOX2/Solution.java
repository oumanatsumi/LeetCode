package QustionContests.QC_AUTOX2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] honeyQuotes(int[][] handle) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Double> ansList = new ArrayList<>();
        for (int i = 0; i < handle.length; i++) {
            switch (handle[i][0]){
                case 1:
                    map.put(handle[i][1],map.getOrDefault(handle[i][1],0)+1);
                    break;
                case 2:
                    map.put(handle[i][1],map.get(handle[i][1])-1);
                    if(map.get(handle[i][1]) == 0){
                        map.remove(handle[i][1]);
                    }
                    break;
                case 3:
                    if(map.isEmpty()){
                        ansList.add(-1.0);
                        continue;
                    }
                    int total = 0;
                    int cnt = 0;
                    for(Integer key:map.keySet()){
                        cnt += map.get(key);
                        total += key * map.get(key);
                    }
                    ansList.add( (double)total /(double) cnt);
                    break;
                case 4:
                    if(map.isEmpty()){
                        ansList.add(-1.0);
                        continue;
                    }
                    int _total = 0;
                    int _cnt = 0;
                    double d = 0.0f;
                    for(Integer key:map.keySet()){
                        _cnt += map.get(key);
                        _total += key * map.get(key);
                    }
                    double avg = (double)_total /(double) _cnt;

                    for(Integer key:map.keySet()){
                        d += Math.pow(avg - (double) key, 2) * (double) map.get(key);
                    }
                    ansList.add(d/(double) _cnt);
                    break;
            }
        }
        double[] ans = new double[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{1, 94}, {2, 94}, {1, 58}, {4}, {3}, {4}, {2, 58}, {3}, {1, 5}};
        double[] ans = s.honeyQuotes(arr);
        for (double d :ans){
            System.out.println(d);
        }
    }
}
