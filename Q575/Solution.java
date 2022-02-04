package LeetCode.Q575;

import java.util.*;

/**
 * @author Ouma Natsumi
 */
public class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int candy:candyType)
        {
            set.add(candy);
        }
        return Math.min(set.size(),candyType.length/2);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] n = {1,1,2,2,3,3};
        System.out.println(s.distributeCandies(n));
    }

}
