package QC336_1;

public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right ; i++) {
            if(check(words[i])){
                cnt++;
            }
        }
        return cnt;
    }

    boolean check(String word){
        int n = word.length();
        if((word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'u' || word.charAt(0) == 'i' ||word.charAt(0) == 'o')
         && (word.charAt(n-1) == 'a' || word.charAt(n-1) == 'e' || word.charAt(n-1) == 'u' || word.charAt(n-1) == 'i' ||word.charAt(n-1) == 'o'))
        {
            return true;
        }
        else return false;
    }
}
