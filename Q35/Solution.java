package Q35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right =nums.length-1;
        while(left<=right)
        {
            int midIndex = (left+right)/2;
            int mid = nums[midIndex];
            if(mid == target)
            {
                return midIndex;
            }
            else if(mid > target)
            {
                right = midIndex -1;
            }
            else
            {
                left = midIndex + 1;
            }
        }
            return left;
    }
    public static void main(String args[])
    {
        Solution solution=new Solution();
        int[] a={1};
        int res = solution.searchInsert(a,0);
        System.out.println(res);
    }

}
