package Q33;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1, mid;
        // 难点，第一次二分，为了找到分界点
        // 二分查找，每次都用mid和最左边的数字对比
        // 如果mid大于最左边的数，说明左边的都有序，分界点在右边
        // 反之，分界点在左边（最后需要注意下中止条件，是取l还是r）
        while (l <= r) {
            mid = (l + r) >>> 1;
            if (nums[0] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int seg = l;
        // l 即为分界点，若l结果为n，就是没有旋转
        // 题目保证必定旋转，所以不旋转的情况只有n = 1的情况
        if(n == 1) return nums[0] == target ? 0 : -1;
        // 如果target比第一个数字大，那搜索范围就是[0, seg-1]
        // 如果target比最后一个数字小，那搜索范围就是[seg, n-1]
        // 如果都不满足，那就不存在
        if(target >= nums[0]){
            l = 0;
            r = seg-1;
        }else if(target <= nums[n-1]){
            l = seg;
            r = n-1;
        }else {
            return -1;
        }
        while (l <= r){
            mid = (l + r) >>> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
