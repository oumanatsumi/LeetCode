package Q6284;

import java.util.Arrays;

public class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] w1Dic = new int[26];
        int[] w2Dic = new int[26];
        int w1Cnt = 0;
        int w2Cnt = 0;
        for(char c:word1.toCharArray()){
            w1Dic[c-'a'] ++;
        }
        for(char c:word2.toCharArray()){
            w2Dic[c-'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if(w1Dic[i] != 0) w1Cnt++;
            if(w2Dic[i] != 0) w2Cnt++;
        }

//        if(Math.abs(w1Cnt - w2Cnt) == 0) return true;
//        else if(Math.abs(w1Cnt - w2Cnt) > 2) return false;

        for (int i = 0; i < 26; i++) {
            if(w1Dic[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if(w2Dic[j] == 0) continue;
                int[] neww1Dic = Arrays.copyOf(w1Dic,26);
                int[] neww2Dic = Arrays.copyOf(w2Dic,26);
                neww1Dic[i]--;
                neww1Dic[j]++;
                neww2Dic[i]++;
                neww2Dic[j]--;
                if(check(neww1Dic,neww2Dic)) return true;
            }
        }
        return false;
//        else if(Math.abs(w1Cnt - w2Cnt) == 2){
//            if(w1Cnt > w2Cnt){
//                boolean cond1 = false;
//                boolean cond2 = false;
//                for (int i = 0; i < 26; i++) {
//                    if(w1Dic[i] != 0 && w2Dic[i] >1 )  cond1 = true;
//                    if(w1Dic[i] == 1 && w2Dic[i] == 0) cond2 = true;
//                }
//                if(cond1 && cond2) return true;
//                else return false;
//            }
//            else {
//                boolean cond1 = false;
//                boolean cond2 = false;
//                for (int i = 0; i < 26; i++) {
//                    if(w2Dic[i] != 0 && w1Dic[i] >1 )  cond1 = true;
//                    if(w2Dic[i] == 1 && w1Dic[i] == 0) cond2 = true;
//                }
//                if(cond1 && cond2) return true;
//                else return false;
//            }
//        }
//        else if(Math.abs(w1Cnt - w2Cnt) == 1){
//
//        }

    }

    boolean check(int[] w1Dic,int[] w2Dic){
        int w1Cnt = 0;
        int w2Cnt = 0;
        for (int i = 0; i < 26; i++) {
            if(w1Dic[i] != 0) w1Cnt++;
            if(w2Dic[i] != 0) w2Cnt++;
        }
        return w1Cnt == w2Cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isItPossible("a","bb");
    }
}
