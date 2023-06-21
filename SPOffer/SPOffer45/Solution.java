package SPOffer.SPOffer45;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String minNumber(int[] nums) {
        String[] ns = new String[nums.length];
        for(int i = 0;i<ns.length;i++){
            ns[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ns, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int) (Long.valueOf(o1+o2) - Long.valueOf(o2+o1));
            }
        });
        return String.join("",ns);
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.minNumber(new int[]{3,30,34,301,305}));
    }
}
