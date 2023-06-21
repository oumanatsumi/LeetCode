package Q501_1000.Q912;

import java.util.Arrays;

class Solution {

    /**
     *  快速排序
     */
//    public int[] sortArray(int[] nums) {
//        partition(nums,0,nums.length-1);
//        return nums;
//    }
//
    private void partition(int[] array, int l, int r){
        if(l >= r) return;
        int cur = array[l];
        int i = l,j = r;
        while (i < j){
            while (i < j && array[j] >= cur){
                j--;
            }
            if(i < j){
                array[i] = array[j];
                i++;
            }
            while (i<j && array[i] <= cur){
                i++;
            }
            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = cur;
        partition(array,l,i-1);
        partition(array,i+1,r);
    }

    /**
     * 基数排序
     */
//    public int[] sortArray(int[] nums) {
//
//    }

    /**
     * 归并排序
     */

    public int[] sortArray(int[] nums) {
        int[] arrayCopy = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, arrayCopy, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] array, int[] arrayCopy, int l, int r) {
        if (l < r) {
            int mid = (l + r) >>> 1;
            // 递归左边
            mergeSort(array, arrayCopy, l, mid);
            // 递归右边
            mergeSort(array, arrayCopy, mid + 1, r);
            // 合并
            merge(array, arrayCopy, l, r, mid);
        }
    }

    private void merge(int[] array, int[] arrayCopy, int l, int r, int mid) {
        int lPos = l, rPos = mid + 1, cur = l;
        while (lPos <= mid && rPos <= r) {
            if (array[lPos] < array[rPos]) {
                arrayCopy[cur] = array[lPos];
                lPos++;
                cur++;
            } else {
                arrayCopy[cur] = array[rPos];
                rPos++;
                cur++;
            }
        }
        if (lPos <= mid) // 左边数组还有剩下
        {
            while (lPos <= mid) {
                arrayCopy[cur] = array[lPos];
                lPos++;
                cur++;
            }
        } else {
            while (rPos <= r) {
                arrayCopy[cur] = array[rPos];
                rPos++;
                cur++;
            }
        }

        // 复制回原数组
        for (int i = l; i <= r; i++) {
            array[i] = arrayCopy[i];
        }
    }


}
