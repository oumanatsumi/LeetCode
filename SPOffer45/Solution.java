package SPOffer45;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String minNumber(int[] nums) {
        String[] ns = new String[nums.length];
        for(int i = 0;i<ns.length;i++){
            ns[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ns, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int s1= o1.length(),s2 = o2.length();
                for(int i = 0;i<Math.min(s1,s2);i++){
                    s1
                }
                return 0;
            }
        }

    }
}
