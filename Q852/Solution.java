package LeetCode.Q852;

import java.util.List;

public class Solution {

//    public int peakIndexInMountainArray(int[] arr) {
//        int index = 0;
//        while(index+1 <arr.length)
//        {
//            if(arr[index]<arr[index+1])
//            {
//                index++;
//            }
//            else
//            {
//                break;
//            }
//        }
//        return index;
//    }


    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<=right)
        {
            int mid = (left + right)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
            {
                return mid;
            }
            else if(arr[mid] < arr[mid+1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] arr = {3,4,5,1};
        int res = s.peakIndexInMountainArray(arr);
        System.out.println(res);
    }
}
