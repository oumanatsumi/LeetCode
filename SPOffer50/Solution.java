package SPOffer50;

class Solution {
    public char firstUniqChar(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a'] ++;
        }
        for(char c : s.toCharArray()){
            if(cnt[c-'a'] == 1) return c;
        }
        return ' ';
    }
}
