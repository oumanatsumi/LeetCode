package LeetCode.Q260;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i:nums)
        {
            if(list.contains(i))
            {
                list.remove(list.indexOf(i));
            }
            else
            {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args)
    {
        int [] nums = {1,2,1,3,2,5};
        Solution s = new Solution();
        int [] res= s.singleNumber(nums);
        for (int i:
            res ) {
            System.out.println(i);
        }
    }

}
