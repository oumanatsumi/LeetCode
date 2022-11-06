package Q6230;

import java.util.*;

public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] map = new int[100001];
        Set<Integer> set = new HashSet<>();
        long total = 0;
        long max = 0 ;
        for (int i = 0; i < k; i++) {
            total += nums[i];
            set.add(nums[i]);
            map[nums[i]]++;
        }
        if(set.size() == k){
            max = Math.max(total,max);
        }

        for (int i = k; i < n; i++) {
            if(map[nums[i-k]] == 1)
            {
                set.remove(nums[i-k]);
            }
            map[nums[i-k]]--;
            total -= nums[i-k];
            set.add(nums[i]);
            total+= nums[i];
            map[nums[i]]++;
            if(set.size() == k){
                max = Math.max(total,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumSubarraySum(new int[]{1,1,1,7,8,9},3);
    }
}
