package Q414;

import java.util.Arrays;
import java.util.Collections;

class Solution {

    //倒序排序搜索
//    public int thirdMax(int[] nums) {
//        Integer[] numList=new Integer[nums.length];
//        for(int i=0;i<nums.length;i++)
//        {
//            numList[i]=nums[i];
//        }
//        Arrays.sort(numList, Collections.reverseOrder());
//
//        int count = 1;
//        int temp=numList[0];
//        int index = 1;
//        while(index < numList.length && count < 3)
//        {
//            if(temp != numList[index])
//            {
//                count ++;
//                temp =numList[index];
//            }
//            index++;
//        }
//        if(count == 3)
//        {
//            return temp;
//        }
//        else
//        {
//            return numList[0];
//        }
//    }


    //正序排序反搜索

//    public int thirdMax(int[] nums) {
//        int len = nums.length;
//        Arrays.sort(nums);
//
//        int count = 1;
//        int temp=nums[len-1];
//        int index = len-1;
//        while(index >=0 && count < 3)
//        {
//            if(temp != nums[index])
//            {
//                count ++;
//                temp =nums[index];
//            }
//            index--;
//        }
//        if(count == 3)
//        {
//            return temp;
//        }
//        else
//        {
//            return nums[len-1];
//        }
//    }

    public int thirdMax(int[] nums)
    {

        int[] maxInts = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int valuableNum = 0;
        boolean hasMin=false;
        int minIndex = findMinInThreeNum(maxInts);
        int min=maxInts[minIndex];

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==Integer.MIN_VALUE && !hasMin)
            {
                hasMin=true;
                valuableNum++;
            }
            if(nums[i]>min)
            {
                boolean isExist= false;
                for(int j=0;j<3;j++)
                {
                    if(maxInts[j]==nums[i] && nums[i]!=Integer.MIN_VALUE)
                    {
                        isExist=true;
                    }
                }
                if(!isExist)
                {
                    maxInts[minIndex]= nums[i];
                    minIndex = findMinInThreeNum(maxInts);
                    min=maxInts[minIndex];
                    valuableNum++;
                }
            }
        }
        if(valuableNum<3)
        {
            int max=Integer.MIN_VALUE;
            for(int j=0;j<3;j++)
            {
                if(maxInts[j]>max)
                {
                    max = maxInts[j];
                }
            }
            return max;
        }
        return min;
    }

    public int findMinInThreeNum(int[] nums)
    {
        if(nums[0]<nums[1])
        {
            if(nums[0]<nums[2])
            {
                return 0;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            if(nums[1]<nums[2])
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] nums ={-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        int res = s.thirdMax(nums);
        System.out.println(res);
    }



}
