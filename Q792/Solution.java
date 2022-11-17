package Q792;

public class Solution {
    // TLE
//    public int numMatchingSubseq(String s, String[] words) {
//        int res = 0;
//        for(String word: words){
//            int sPos = 0, wordPos = 0;
//            while(sPos < s.length()){
//                if(word.charAt(wordPos) == s.charAt(sPos)){
//                    wordPos ++;
//                }
//                sPos++;
//                if(wordPos == word.length()){
//                    res++;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    //也会TLE，但是用哈希表存一下某个字符出现的位置就行了，懒得写了
    public int numMatchingSubseq(String s, String[] words) {
        int[] wPoints = new int[words.length];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < words.length; j++) {
                if(wPoints[j] < words[j].length() && words[j].charAt(wPoints[j]) == c){
                    wPoints[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if(wPoints[i] == words[i].length()) res ++;
        }
        return res;
    }

}
