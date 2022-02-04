package Q1218;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};

        System.out.println(s.longestSubsequence(arr,0));
    }

}
