package QC331_3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[][] numsANDindex = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsANDindex[i][0] = nums[i];
            numsANDindex[i][1] = i;
        }
        Arrays.sort(numsANDindex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        int[] indexs = new int[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = numsANDindex[i][1];
        }
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(flags[indexs[i]]) continue;
            else {
                if(indexs[i] == 0){
                    flags[0] = true;
                    flags[1] = true;
                }else if(indexs[i] == n-1){
                    flags[n-1] = true;
                    flags[n-2] = true;
                }else {
                    flags[indexs[i]] = true;
                    flags[indexs[i]-1] = true;
                    flags[indexs[i]+1] = true;
                }
                k--;
                if(k== 0) return nums[indexs[i]];
            }
        }
        return nums[indexs[n-1]];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = s.minCapability(new int[]{9,5,2,3}, 1);
        System.out.println(n);
    }
}
