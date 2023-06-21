package SPOffer58_1;

import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split("\\s+");
        for (int i = strings.length-1; i >0 ; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[0]);

       return sb.toString();
    }
}
