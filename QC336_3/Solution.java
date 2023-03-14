package QC336_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0] == 0 ? 1 : 0;
        int[][] prefix = new int[n+1][20];
        int num = 0 ,cnt = 0;
        for (int i = 0; i < n; i++) {
            num = nums[i];
            cnt = 0;
            for (int j = 0; j < 20; j++) {
                prefix[i+1][j] = prefix[i][j] +num % 2;
                num = num >> 1;
            }
        }

        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < 20; j++) {
                if(prefix[i][j] % 2 == 1){
                    tmp += 1 << j;
                }
            }
            if(map.containsKey(tmp)){
                res += map.get(tmp);
            }
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
       long res = s.beautifulSubarrays(new int[]{4,3,1,2,4});
        System.out.println(res);
    }
}
