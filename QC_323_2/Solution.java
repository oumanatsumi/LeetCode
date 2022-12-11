package QC_323_2;

import java.util.*;

public class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] map = new int[100002];
        int[] cnt = new int[n];

        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            map[nums[i]] = i;
            int sqrn = (int) Math.sqrt(nums[i]);
            if(sqrn*sqrn!= nums[i]){
                cnt[i] = 1;
                continue;
            }
            int index = map[sqrn];
            if(index != -1){
                cnt[i] = cnt[index]+1;
            }else {
                cnt[i] = 1;
            }
        }
        int max =0;
        for(int i:cnt){
            max = Math.max(i,max);
        }
        return max <2? -1 :max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestSquareStreak(new int[]{4,3,6,16,8,2});
    }
}
