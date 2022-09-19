package SPOffer32_4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int[] sumPrefixScores(String[] words) {
        if(words.length == 1){
            return new int[]{words[0].length()};
        }
        int n = words.length;
        char[][] cs = new char[n][1001];
        
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.sumPrefixScores(new String[] {"abc","ab","bc","b"});
        for (int a:ans) {
            System.out.println(a);
        }
    }
}
