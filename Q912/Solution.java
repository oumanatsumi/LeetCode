package Q912;

public class Solution {

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
}
