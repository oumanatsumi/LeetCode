package Q1501_2000.Q1608;


import java.util.*;

class Solution {
    public int specialArray(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,Collections.reverseOrder());

        for (int i = 1; i <= arr.length; ++i) {
            if (arr[i-1] >= i && (i == arr.length || arr[i] < i)) {
                return i;
            }
        }
        return -1;
    }

}
