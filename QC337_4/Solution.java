package QC337_4;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = (nums[i] % value + value) % value;
            map.put(tmp, map.getOrDefault(tmp, 0) +1 );
        }

        int minCnt = Integer.MAX_VALUE , minIndex = 0, curIndex = 0;
        boolean flag = true;
        for(int i: map.keySet()){
            if(i != curIndex){
                flag = false;
                break;
            }
            if(minCnt > map.get(i)){
                minIndex = i;
                minCnt = map.get(i);
            }
            curIndex++;
        }
        if(flag){
            if(curIndex < value){
                return curIndex;
            }else {
                return value * minCnt + minIndex;
            }
        }else {
            return curIndex;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSmallestInteger(new int[]{3,0,3,2,4,2,1,1,0,4}, 5));
    }
}
