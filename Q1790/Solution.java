package Q1790;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] map = new int[26];
        int diffCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!= s2.charAt(i)){
                diffCnt++;
                map[s1.charAt(i)-'a'] ++;
                map[s2.charAt(i)-'a'] --;
            }
        }
        if(diffCnt == 0){
            return true;
        }
        else if(diffCnt == 2){
            for (int i = 0; i < 26; i++) {
                if(map[i] != 0) return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
