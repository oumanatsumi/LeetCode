package Q2001_2500.Q2309;

class Solution {
    public String greatestLetter(String s) {
        boolean[] mapLow = new boolean[26];
        boolean[] mapHigh = new boolean[26];
        String res = "";
        for(char c : s.toCharArray()){
            int index = -1;
            if(c > 'Z'){
                index = c - 'a';
                mapLow[index] = true;
                c -= 32;
            }else {
                index = c - 'A';
                mapHigh[index] = true;
            }
            if(mapLow[index] && mapHigh[index]){
                if(res.equals("") || res.charAt(0) < c){
                    res = "" +c;
                }
            }
        }
        return res;
    }
}
