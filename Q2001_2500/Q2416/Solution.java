package Q2001_2500.Q2416;

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        char[][] cs = new char[n][];
        for (int i = 0; i < n; i++) {
            cs[i] = words[i].toCharArray();
        }
        int[] res = new int[n];
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] is = s.sumPrefixScores(new String[]{"sss","11seda","sdasdx"});

    }

}
