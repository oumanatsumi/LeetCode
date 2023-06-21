package Q1_500.Q496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    // 直接
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//        for (int i =0;i<nums2.length;i++)
//        {
//            map.put(nums2[i],i);
//        }
//        int [] res = new int[nums1.length];
//        for (int i =0;i<nums1.length;i++)
//        {
//            boolean flag = false;
//            for(int j=map.get(nums1[i]);j<nums2.length;j++)
//            {
//                if(nums2[j] > nums1[i])
//                {
//                    flag = true;
//                    res[i] = nums2[j];
//                    break;
//                }
//            }
//            if(!flag)
//            {
//                res[i] = -1;
//            }
//        }
//        return res;
//    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        map.put(nums2[nums2.length-1],-1);
        stack.push(nums2[nums2.length-1]);
        for(int i =nums2.length-2;i>=0;i--)
        {
            while(true)
            {
                if(!stack.isEmpty() && stack.peek()<nums2[i])
                {
                    stack.pop();
                    continue;
                }
                else if(stack.isEmpty())
                {
                    map.put(nums2[i],-1);
                    break;
                }
                else if(stack.peek()>nums2[i])
                {
                    map.put(nums2[i],stack.peek());
                    break;
                }
            }
            stack.push(nums2[i]);
        }
        int [] res = new int[nums1.length];
        for(int i =0;i<nums1.length;i++)
        {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] nums1 =new int[]{4,1,2};
        int[] nums2 =new int[]{1,3,4,2};
        int [] res = s.nextGreaterElement(nums1,nums2);
        for (int i:res
             ) {
            System.out.println(i);
        }
    }
}
