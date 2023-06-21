package QInterview_1705;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length, letterCnt = 0, numCnt = 0;
        int curDiff = 0, max = 0, left = 0,right = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            if(array[i].charAt(0) >= '0' && array[i].charAt(0) <='9'){
                numCnt ++ ;
            }else {
                letterCnt ++;
            }
            curDiff = letterCnt - numCnt;
            if(map.containsKey(curDiff)){
                int index = map.get(curDiff);
                if(i - index > max){
                    max = i - index;
                    left = map.get(curDiff);
                    right = i + 1;
                }
            }
            else {
                map.put(curDiff,i);
            }
        }

        if(max == 0){
            return new String[]{};
        }else {
            return Arrays.copyOfRange(array,left+1,right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[]  res = s.findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"});
        System.out.println(res);
    }
}
