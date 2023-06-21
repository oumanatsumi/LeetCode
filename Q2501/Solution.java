package Q2501;

import java.util.*;

class Solution {
//    public int longestSquareStreak(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        int[] map = new int[100002];
//        int[] cnt = new int[n];
//
//        for (int i = 0; i < map.length; i++) {
//            map[i] = -1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            map[nums[i]] = i;
//            int sqrn = (int) Math.sqrt(nums[i]);
//            if(sqrn*sqrn!= nums[i]){
//                cnt[i] = 1;
//                continue;
//            }
//            int index = map[sqrn];
//            if(index != -1){
//                cnt[i] = cnt[index]+1;
//            }else {
//                cnt[i] = 1;
//            }
//        }
//        int max =0;
//        for(int i:cnt){
//            max = Math.max(i,max);
//        }
//        return max <2? -1 :max;
//    }

    public int longestSquareStreak(int[] nums) {
        final int MAX = 100005;
        final int LIMIT = (int) Math.sqrt(MAX);
        Set<Integer> sets = new HashSet<>();
        for(int i:nums) sets.add(i);
        int ans = 0;
        for (int i :nums) {
            int tmp = 0;
            if(i > LIMIT) continue;
            while (i< MAX && sets.contains(i)){
                i *= i;
                tmp++;
            }
            ans = Math.max(tmp,ans);
        }
        return ans >1 ? ans : -1;
    }

}
