package SPOffer.SPOffer51;

import java.util.Arrays;

class Solution {

    /**
     *      方法一： 归并排序（自下而上）
     */

    int res = 0;
    public int reversePairs(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        mergeSort(nums, Arrays.copyOf(nums, nums.length));
        for(int i:nums){
            System.out.print(i + " ");
        }
        return res;
    }

    private void mergeSort(int[] arr, int[] arr_copy){
        int n = arr.length;
        int maxStep = 2;
        for (int i = 2; i <= n ; i = i*2) {
            maxStep = i;
            for (int j = 0; j <= n-i/2; j+= i) {
                merge(arr, arr_copy, j,j +(i/2)-1,Math.min(j+i-1,n-1));
            }
        }
        merge(arr, arr_copy, 0,maxStep-1,n-1);
    }

    private void merge(int[] arr, int[] arr_copy, int l, int mid, int r){
        int lPos = l, rPos = mid+1, cur = l;
        while(lPos <= mid && rPos <= r){
            if(arr[lPos] <= arr[rPos]){
                arr_copy[cur++] = arr[lPos];
                lPos++;
            }else {
                arr_copy[cur++] = arr[rPos];
                res += mid - lPos + 1;
                rPos++;
            }
        }
        if(lPos >= mid){
            while (rPos <= r){
                arr_copy[cur++] = arr[rPos];
                rPos++;
            }
        }
        if(rPos >= r){
            while (lPos <= mid){
                arr_copy[cur++] = arr[lPos];
                lPos++;
            }
        }
        for (int i = l; i <= r; i++) {
            arr[i] = arr_copy[i];
        }
    }







    /**
     *         方法二：离散化 + 树状数组
     *
     */

//    int n;
//    public int reversePairs(int[] nums) {
//        n = nums.length;
//        int[] discretized = discretization(nums);
//        int[] tree = new int[n+1];
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += query(tree, discretized[i]);
//            add(tree,discretized[i]);
//        }
//        long total = (long) n *(n-1)/2;
//        return (int)(total - sum);
//    }
//
//    private int[] discretization(int[] arr){
//        int[][] arr_ = new int[arr.length][2];
//        for (int i = 0; i < arr.length; i++) {
//            arr_[i][0] = arr[i];
//            arr_[i][1] = i+1;   // 因为线段树是从1开始的
//        }
//        Arrays.sort(arr_, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if((long)o1[0] - (long)o2[0] > 0 ) return 1;
//                else if((long)o1[0] - (long)o2[0] < 0) return -1;
//                else return 0;
//            }
//        });
//        int[] ret = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ret[i] = arr_[i][1];
//        }
//        return ret;
//    }
//
//    private int lowBit(int x){
//        return x & (-x);
//    }
//
//    private void add(int[] arr, int x){
//        for (int i = x; i < n+1; i= i+lowBit(i)) {
//            arr[i]++;
//        }
//    }
//    private int query(int[] arr, int x){
//        int ret = 0;
//        for (int i = x; i > 0; i=i-lowBit(i)) {
//            ret += arr[i];
//        }
//        return ret;
//    }



    public static void main(String[] args) {
        Solution s = new Solution();
        long r = s.reversePairs(new int[]{2,5,3,1,4,0,2});
        System.out.println(r);
    }
}
