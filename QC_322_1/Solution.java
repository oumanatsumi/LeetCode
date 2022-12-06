package QC_322_1;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] ss = sentence.split(" ");
        char temp = ss[0].charAt(ss[0].length()-1);
        for (int i = 1; i < ss.length; i++) {
            if(ss[i].charAt(0) != temp) return false;
            temp = ss[i].charAt(ss[i].length()-1);
        }
        return temp == ss[0].charAt(0);
    }
}
