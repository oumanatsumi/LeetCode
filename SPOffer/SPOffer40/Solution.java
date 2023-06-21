package SPOffer.SPOffer40;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length<=k) return arr;
        partition(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);
    }

    private void partition(int[] array, int l, int r, int k){
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
        if(i == k){
            return;
        }
        if(i > k) partition(array,l,i-1,k);
        if(i < k) partition(array,i+1,r,k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.getLeastNumbers(new int[]{3,2,1} , 2);
        for(int i :r){
            System.out.println(i);
        }
    }
}
