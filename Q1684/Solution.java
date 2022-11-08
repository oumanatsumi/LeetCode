package Q1684;

import java.util.Arrays;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] all = new boolean[26];
        Arrays.fill(all, false);
        for(char c: allowed.toCharArray()){
            all[c-'a'] = true;
        }
        int cnt = 0;
        for(String word: words)
        {
            boolean flag = true;
            for(char c :word.toCharArray()){
                if(!all[c-'a']){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}
