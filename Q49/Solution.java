package Q49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        int[] letterMap;
        for (int i = 0; i < n; i++) {
            StringBuilder key = new StringBuilder();
            letterMap = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                letterMap[strs[i].charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                key.append(String.format("%02d", letterMap[j]));
            }
            if(!map.containsKey(key.toString())){
                map.put(key.toString(),new ArrayList<>());
            }
            map.get(key.toString()).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
}
