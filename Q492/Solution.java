package Q492;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ouma Natsumi
 */

class Solution {

    //先来个常规做法

//    public int[] constructRectangle(int area) {
//        List<Integer> nums = new ArrayList<Integer>();
//        for(int i=1;i<=area/2+1 ;i++)
//        {
//            if(area%i ==0)
//            {
//                nums.add(i);
//            }
//        }
//        int minDis = Integer.MAX_VALUE;
//        int width =0,length=0;
//        int[] res = new int[2];
//        for (int num:nums
//             ) {
//            width = num;
//            length = area / width;
//            if(length - width>=0 && length - width<minDis)
//            {
//                minDis = length-width;
//                res[0] = length;
//                res[1] = width;
//            }
//        }
//        return res;
//    }

    public int[] constructRectangle(int area) {

        int mid = (int)Math.sqrt(area);
        int left=mid,right=mid;
        int count = 0;
        while(left>=1 && right<=area)
        {
            if(count %2 ==0)
            {
                if(area % left ==0)
                {
                    right = area / left;
                    return new int[]{right,left};
                }
                else
                {
                    count ++;
                    left --;
                }
            }
            else
            {
                if(area % right ==0)
                {
                    left = area / right;
                    return new int[]{right,left};
                }
                else
                {
                    count ++;
                    right ++;
                }
            }
        }
        int [] res = new int[2];
        res[0] = area;
        res[1] = 1;
        return res;
    }




    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] res = s.constructRectangle(2);
        System.out.println(res[0]+","+res[1]);
    }

}
