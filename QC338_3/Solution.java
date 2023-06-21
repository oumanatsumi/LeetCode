package QC338_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length,m = queries.length;
        Arrays.sort(nums);
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int index;
        long leftSum,rightSum,resTmp;
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            index = subFind(nums, queries[i]);
            if(index < 0) {
                leftSum = 0;
                rightSum = prefix[n-1];
            }
            else {
                leftSum = prefix[index];
                rightSum = prefix[n-1] - prefix[index];
            }
            resTmp = (long) queries[i] * (index+1) - leftSum + rightSum - ((long) queries[i] * (n- index -1));
            res.add(resTmp);
        }
        return res;
    }

    private int subFind(int[] nums, int target){
        int left = 0 , right = nums.length-1;
        int mid ;
        while (left <= right){
            mid = (left + right)>>>1;
            if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Long> res = s.minOperations(new int[]{47,50,97,58,87,72,41,63,41,51,17,21,7,100,69,66,79,92,84,9,57,26,26,28,83,38},
                new int[] {50,84,76,41,64,82,20,22,64,7,38,92,39,28,22,3,41,46,47,50,88,51,9,49,38,67,26,65,89,27,71,25,77,72,65,
                        41,84,68,51,26,84,24,79,41,96,83,92,9,93,84,35,70,74,79,37,38,26,26,41,26});
    }
}
