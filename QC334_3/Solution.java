package QC334_3;

import java.util.Arrays;

class Solution {
    //  贪心+二分匹配的位置 超时
//    int n ;
//    public int maxNumOfMarkedIndices(int[] nums) {
//        n = nums.length;
//        Arrays.sort(nums);
//        boolean[] visited = new boolean[n];
//        int ans = 0, index = 0;
//        for (int i = n/2-1; i >= 0; i--) {
//            if(visited[i]) continue;
//            index = find(nums, nums[i]*2);
//            if(index == n) continue;
//            while (index <n && visited[index]){
//                index ++ ;
//            }
//            if(index <  n) {
//                visited[i] = true;
//                visited[index] = true;
//                ans += 2;
//            }
//        }
//        return ans;
//    }
//
//    private int find(int[] nums, int target){
//        int l= 0 ,r = n-1, mid = 0 ;
//        if(target > nums[r]) return n;
//        while (l <= r){
//            mid = (l + r) >>> 1;
//            if(nums[mid] >= target){
//                r = mid -1;
//            }else {
//                l = mid +1;
//            }
//        }
//        return l;
//    }


    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = n/2, mid = 0;
        while (l <= r){
            mid = (l + r) >>> 1;
            boolean flag = true;
            for (int i = 0; i < mid; i++) {
                if(nums[i] * 2 > nums[n - mid + i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                l = mid +1 ;
            }
            else {
                r = mid - 1;
            }
        }
        return r*2;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.maxNumOfMarkedIndices(new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,
                71,14,64,29,15,40});
        System.out.println(res);
    }
}
