package Q2325;

import java.util.Arrays;

class Solution {
    public String decodeMessage(String key, String message) {
        int[] map = new int[26];
        Arrays.fill(map,-1);
        key = key.replaceAll(" ","");
        int cur = 0;
        for (int i = 0; i < key.length(); i++) {
            char temp = key.charAt(i);
            if(map[temp-'a'] == -1){
                map[temp-'a'] = cur;
                cur++;
            }
        }
        String res = "";
        for(char c : message.toCharArray()){
            if(c == ' '){
                res += ' ';
                continue;
            }
            res += (char)('a' + map[c-'a']);
        }
        return res;
    }
}
