package QC_DoubleWeek105_2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> set = new HashSet<>();
    int min = Integer.MAX_VALUE;
    public int minExtraChar(String s, String[] dictionary) {
        for(String d: dictionary){
            set.add(d);
        }
        backTrack(s, 0, 0);
        return min;
    }

    private void backTrack(String s, int begin, int letterNum){
        if(letterNum > min) return;
        for (int i = begin; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if(set.contains(s.substring(i,j))){
                    letterNum += i-begin;
                    backTrack(s, j, letterNum);
                    letterNum -= i-begin;
                }
            }
        }
        letterNum += (s.length() - begin);
        min = Math.min(letterNum, min);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minExtraChar("smsvy",new String[]{
               "y","m","s"});
        System.out.println(res);
    }
}
