package Q1663;

class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = k - 26*(n-i-1);
            if(temp <= 0) {
                sb.append('a');
                k--;
            }else{
                char c = (char) ('a'+Math.min(temp-1,25));
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
