package Q1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        Arrays.sort(sortedArr);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i:sortedArr)
        {
            if(!map.containsKey(i))
            {
                map.put(i,map.size()+1);
            }
        }
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] arr = {100,100,100};
        int[] n = s.arrayRankTransform(arr);
        for(int i:n)
        {
            System.out.println(i);
        }
    }
}
