package Q775;

import java.util.Arrays;

class Solution {
    int totalReverseCnt = 0;

    public boolean isIdealPermutation(int[] nums) {
        int[] arrayCopy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) totalReverseCnt--;
        }

        mergeSort(nums, arrayCopy, 0, nums.length - 1);
        return totalReverseCnt == 0;
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
                totalReverseCnt += (mid - lPos + 1);
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

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isIdealPermutation(new int[]{2,5,3,1,4,0,2});
    }
}
