package QustionContests.QC334_2;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        long y = 0;
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            y = y * 10 + word.charAt(i) - '0';
            y = y % m;
            if(y == 0) ans[i] = 1;
            else ans[i] = 0;
        }
        return ans;
    }
}