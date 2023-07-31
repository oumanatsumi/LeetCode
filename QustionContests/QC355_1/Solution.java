package QustionContests.QC355_1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        String sep = String.valueOf(separator);
        if(separator == '.'){
            sep = "\\.";
        }else if( separator == '|'){
            sep = "\\|";
        }else if(separator == '$'){
            sep = "\\$";
        }
        for(String word : words){
            if(word.length() > 0 && word.charAt(word.length()-1) == separator) word = word.substring(0,word.length()-1);
            if(word.length() > 0 && word.charAt(0) == separator) word = word.substring(1,word.length());
            String[] temps = word.split(sep);
            for(String s: temps){
                if(!s.equals(""))   res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> strings = new ArrayList<>();
        strings.add("#a$f$nwgq#vw");
        s.splitWordsBySeparator(strings,'$');
    }
}
