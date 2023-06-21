package Q391;

import java.util.*;

class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        //先找到最大的总面积
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        int totalArea = 0;
        Map<List<Integer>,Integer> map = new HashMap<>();
        for (int[] rectangle:rectangles) {
            if(rectangle[0]<minX)
            {
                minX =rectangle[0];
            }
            if(rectangle[1]<minY)
            {
                minY =rectangle[1];
            }
            if(rectangle[2]>maxX)
            {
                maxX =rectangle[2];
            }
            if(rectangle[3]>maxY)
            {
                maxY =rectangle[3];
            }
            List<Integer> intsTemp1 = new ArrayList<>();
            intsTemp1.add(rectangle[0]);
            intsTemp1.add(rectangle[1]);
            List<Integer> intsTemp2 = new ArrayList<>();
            intsTemp2.add(rectangle[2]);
            intsTemp2.add(rectangle[3]);
            List<Integer> intsTemp3 = new ArrayList<>();
            intsTemp3.add(rectangle[2]);
            intsTemp3.add(rectangle[1]);
            List<Integer> intsTemp4 = new ArrayList<>();
            intsTemp4.add(rectangle[0]);
            intsTemp4.add(rectangle[3]);
            map.put(intsTemp1,map.getOrDefault(intsTemp1,0)+1);
            map.put(intsTemp2,map.getOrDefault(intsTemp2,0)+1);
            map.put(intsTemp3,map.getOrDefault(intsTemp3,0)+1);
            map.put(intsTemp4,map.getOrDefault(intsTemp4,0)+1);
            totalArea += (rectangle[2] - rectangle[0])*(rectangle[3] - rectangle[1]);
        }
        if(totalArea != (maxX-minX)*(maxY-minY))
        {
            return false;
        }

        for (List<Integer> ints : map.keySet())
        {
            if(ints.get(0) == minX && ints.get(1) ==minY || ints.get(0) == maxX && ints.get(1) ==maxY ||
               ints.get(0) == minX && ints.get(1) ==maxY || ints.get(0) == maxX && ints.get(1) ==minY)
            {
                if(map.get(ints)!=1)
                {
                    return false;
                }
            }
            else
            {
                if(map.get(ints)!=2 && map.get(ints)!=4)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int [][] martix ={{1,1,3,3}, {3,1,4,2}, {3,2,4,4},{1,3,2,4}, {2,3,3,4}};
        System.out.println(s.isRectangleCover(martix));
    }
}
