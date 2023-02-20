package Q6361;

import java.util.Arrays;

public class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        return n == 3 ? 0 : Math.min(nums[n-3] - nums[0], Math.min(nums[n-2]-nums[1],nums[n-1]-nums[2]));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimizeSum(new int[]{40,60,23,99,83,5,21,76,34,99});
    }
}
