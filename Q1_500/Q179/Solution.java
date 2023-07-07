package Q1_500.Q179;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] ns = new Integer[n];
        for (int i = 0; i < n; i++) {
            ns[i] = nums[i];
        }
        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString();
                String s2 = o2.toString() + o1.toString();
                for (int i = 0; i < s1.length(); i++) {
                    if(s1.charAt(i) > s2.charAt(i)) return -1;
                    else if(s1.charAt(i) < s2.charAt(i)) return 1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer integer : ns){
            sb.append(integer);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
