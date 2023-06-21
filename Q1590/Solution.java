package Q1590;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = (prefix[i] + nums[i] % p)%p;
        }
        int min = n;
        Map<Integer,Integer> last = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            last.put(prefix[i], i);
            int j  = last.getOrDefault((prefix[i] - prefix[n] + p) % p, -n);
            min = Math.min(i-j , min);
        }
        return min >= n? -1:min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2},148));
    }
}
