package Q1501_2000.Q1668;

class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int len = word.length();
        int times = n/ len;
        for (int i = times; i >= 1; i--) {
            String curWord = "";
            for (int j = 0; j < i; j++) {
                curWord += word;
            }
            for (int j = 0; j < n-(i*len)+1; j++) {
                if(sequence.substring(j,j+i*len).equals(curWord)) return i;
            }
        }
        return 0;
    }
}
