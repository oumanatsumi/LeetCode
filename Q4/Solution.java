package Q4;

import javax.xml.transform.SourceLocator;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums = new int[nums1.length+nums2.length];
//        System.arraycopy(nums1, 0, nums, 0, nums1.length);
//        System.arraycopy(nums2, 0, nums, nums1.length, nums1.length + nums2.length - nums1.length);
//        Arrays.sort(nums);
//        if(nums.length % 2 ==1)
//        {
//            return nums[nums.length/2];
//        }
//        else
//        {
//            return (nums[nums.length/2]+nums[nums.length/2-1])/2.0;
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1=0,ptr2=0;
        int len1=nums1.length,len2= nums2.length;
        boolean end1 = len1 == 0;
        boolean end2 = len2 == 0;
        if((len1+len2)%2==1)
        {
            int target =(len1+len2)/2;
            int res=0;
            while(target >= 0)
            {
                //数组1到头了
                if(end1)
                {
                    res = nums2[ptr2];
                    ptr2++;
                }
                else if(end2)
                {
                    res = nums1[ptr1];
                    ptr1++;
                }
                else if(nums1[ptr1]<nums2[ptr2])
                {
                    res = nums1[ptr1];
                    ptr1++;
                    if(ptr1==len1){
                        end1=true;
                    }
                }
                else
                {
                    res = nums2[ptr2];
                    ptr2++;
                    if(ptr2==len2){
                        end2=true;
                    }
                }
                target--;
            }
            return res;
        }
        else
        {
            int target =(len1+len2)/2 ;
            int res=0, res2=0;
            while(target >= 0)
            {
                if(target == 0)
                {
                    res2=res;
                }
                //数组1到头了
                if(end1)
                {
                    res = nums2[ptr2];
                    ptr2++;
                }
                else if(end2)
                {
                    res = nums1[ptr1];
                    ptr1++;
                }
                else if(nums1[ptr1]<nums2[ptr2])
                {
                    res = nums1[ptr1];
                    ptr1++;
                    if(ptr1==len1){
                        end1=true;
                    }
                }
                else
                {
                    res = nums2[ptr2];
                    ptr2++;
                    if(ptr2==len2){
                        end2=true;
                    }
                }
                target--;
            }
            return (res+res2)/2.0;
        }
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] n1 = {1,3,4};
        int[] n2 = {2,6,7};
        double res =s.findMedianSortedArrays(n1,n2);
        System.out.println(res);

    }

}
