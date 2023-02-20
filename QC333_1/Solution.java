package QC333_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int [] num1 :nums1){
            if(map.containsKey(num1[0])){
                map.put(num1[0], map.get(num1[0])+num1[1]);
            }else {
                map.put(num1[0], num1[1]);
            }
        }
        for(int [] num1 :nums2){
            if(map.containsKey(num1[0])){
                map.put(num1[0], map.get(num1[0])+num1[1]);
            }else {
                map.put(num1[0], num1[1]);
            }
        }
        int[][] ans = new int[map.size()][2];
        int index = 0;
        for(int key : map.keySet()){
            ans[index][0] = key;
            ans[index++][1] = map.get(key);
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return ans;
    }
}
