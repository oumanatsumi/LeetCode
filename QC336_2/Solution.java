package QC336_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int res = 0,n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            sum += nums[i];
           if(sum > 0) res ++;
        }
        return res;
    }
}
