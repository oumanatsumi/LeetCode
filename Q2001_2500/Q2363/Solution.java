package Q2001_2500.Q2363;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[1001];
        for (int i = 0; i < items1.length; i++) {
            map[items1[i][0]] += items1[i][1];
        }
        for (int i = 0; i < items2.length; i++) {
            map[items2[i][0]] += items2[i][1];
        }
        for (int i = 0; i < map.length; i++) {
            if(map[i] != 0){
                res.add(IntStream.of(new int[]{i,map[i]}).boxed().collect(Collectors.toList()));
            }
        }
        return res;
    }
}
