package QC340_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr1 = new long[n];
        Map<Integer,Integer> LastMap = new HashMap<>();
        Map<Integer,Integer> CntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curCnt = 0;
            int lastIndex = 0;
            if(!CntMap.containsKey(nums[i])) {
                CntMap.put(nums[i],1);
                LastMap.put(nums[i],i);
            }
            else{
                curCnt = CntMap.get(nums[i]);
                lastIndex = LastMap.get(nums[i]);
                arr1[i] = arr1[lastIndex] + (long) (i - lastIndex) * curCnt;
                CntMap.put(nums[i],curCnt+1);
                LastMap.put(nums[i],i);
            }
        }
        LastMap = new HashMap<>();
        CntMap = new HashMap<>();
        long[] arr2 = new long[n];
        for (int i = n-1; i >= 0; i--) {
            int curCnt = 0;
            int lastIndex = 0;
            if(!CntMap.containsKey(nums[i])) {
                CntMap.put(nums[i],1);
                LastMap.put(nums[i],i);
            }
            else{
                curCnt = CntMap.get(nums[i]);
                lastIndex = LastMap.get(nums[i]);
                arr2[i] = arr2[lastIndex] + (long) (lastIndex - i) * curCnt;
                CntMap.put(nums[i],curCnt+1);
                LastMap.put(nums[i],i);
            }
        }
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i] + arr2[i];
        }
        return arr;
    }
}
