package Q34;

public class Solution {
    // 暴力
//    public int[] searchRange(int[] nums, int target) {
//        int n = nums.length;
//        int start = -1,end = -1;
//        for (int i = 0; i < n; i++) {
//            if(nums[i] == target){
//                start = i;
//                while (i< n && nums[i] == target){
//                    end = i;
//                    i++;
//                }
//                break;
//            }
//        }
//        return new int[]{start,end};
//    }

    // 二分
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int start = lowBound2(nums, target-1)+1;
        int end = lowBound2(nums, target);
        if (end == -1 || nums[end] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{start, end};
        }
    }

    private int lowBound1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int lowBound2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
