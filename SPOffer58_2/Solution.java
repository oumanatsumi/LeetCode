package SPOffer58_2;

class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        String move = s.substring(0,n);
        sb.delete(0,n);
        sb.append(move);
        return sb.toString();
    }
}
