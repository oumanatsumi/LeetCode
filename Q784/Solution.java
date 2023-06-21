package Q784;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backTrack(res,new StringBuilder(s),0);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder s, int i){
        while (i<s.length()){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                i++;
            }else {
                s.setCharAt(i,getUpperOrLower(s.charAt(i)));
                backTrack(res, s ,i+1);
                s.setCharAt(i,getUpperOrLower(s.charAt(i)));
                i++;
            }
        }
        res.add(s.toString());
    }

    private char getUpperOrLower(char c){
        if(c >= 'a' && c <= 'z') return (char) (c-32);
        if(c >= 'A' && c <= 'Z') return (char) (c+32);
        else return c;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.letterCasePermutation(
                "a1b2");
    }
}
