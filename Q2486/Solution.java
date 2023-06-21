package Q2486;

class Solution {
    public int appendCharacters(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int s1 =0,t1 = 0;
        while(s1 < slen && t1 < tlen){
            if(s.charAt(s1) == t.charAt(t1)){
                t1++;
            }
            s1++;
        }
        if(t1 == tlen) return 0;
        else {
            return tlen - t1;
        }
    }
}
