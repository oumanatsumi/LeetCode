package Q1662;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
//    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        int aLen = word1.length,bLen = word2.length;
//        int aIndex=0,bIndex=0,p1=0,p2=0;
//        while(aIndex<aLen && bIndex<bLen){
//            if(word1[aIndex].charAt(p1) != word2[bIndex].charAt(p2)) return false;
//            p1++;p2++;
//            if(p1>=word1[aIndex].length()){
//                p1 = 0;
//                aIndex++;
//            }
//            if(p2>=word2[bIndex].length()){
//                p2 = 0;
//                bIndex++;
//            }
//        }
//        return (aIndex == aLen) == (bIndex == bLen);
//    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("",word2));
    }

}
