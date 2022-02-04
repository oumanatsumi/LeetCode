package Q384;

import java.util.*;

public class Solution {
    int[] originNums;

    public Solution(int[] nums) {
        originNums = nums.clone();
    }


    public int[] reset() {
        return originNums;
    }

    public int[] shuffle() {
        int[] numsCopy = originNums.clone();
        List<Integer> numsList = new ArrayList<>();
        for(int num:numsCopy)
        {
            numsList.add(num);
        }
        int[] res =new int[numsCopy.length];

        for(int i =0;i<res.length;i++)
        {
            Random random = new Random();
            int index = i + random.nextInt(numsCopy.length - i);
            res[i] = numsList.get(index);
            Collections.swap(numsList,i,index);
        }
        return res;
    }
}
