package Q658;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] arr_ = new int [arr.length];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < arr_.length; i++) {
            arr_[i] = Math.abs(arr[i] - x);
            if(arr_[i] < min){
                min = arr_[i];
                minIndex = i;
            }
        }
        int left = minIndex,right = minIndex;
        List<Integer> res = new ArrayList<>();
        res.add(arr[minIndex]);
        k--;
        while(k>0){
            if(left-1 < 0){
                right ++;
                res.add(arr[right]);
            }
            else if(right+1 > arr.length-1)
            {
                left--;
                res.add(0,arr[left]);
            }
            else if(arr_[left-1] <= arr_[right+1])
            {
                left--;
                res.add(0,arr[left]);
            }
            else
            {
                right++;
                res.add(arr[right]);
            }
            k--;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4,5,7,8,9,11,13,15,19,20};
        List<Integer> res = s.findClosestElements(arr,4,11);
        for(int i :res)
        {
            System.out.println(i);
        }
    }
}
