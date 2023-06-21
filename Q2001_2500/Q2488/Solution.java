package Q2001_2500.Q2488;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int index = -1;
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] > k) prefix[i+1] = prefix[i]+1;
            else if(nums[i] == k) prefix[i+1] = prefix[i];
            else prefix[i+1] = prefix[i] - 1;

            if(nums[i] == k) index = i;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <= index; i++) {
            map.put(prefix[i], map.getOrDefault(prefix[i],0)+1);
        }
        int ans = 0;
        for (int i = index+1; i <= n; i++) {
            if(map.containsKey(prefix[i])){
                ans += map.get(prefix[i]);
            }
            if(map.containsKey(prefix[i]-1)){
                ans += map.get(prefix[i]-1);
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.countSubarrays(new int[]{3,2,1,4,5},4);
    }
}
