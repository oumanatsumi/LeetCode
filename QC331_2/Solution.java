package QC331_2;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] cntSum = new int[n];
        cntSum[0] = check(words[0])? 1 : 0;
        for (int i = 1; i < n; i++) {
            if(check(words[i])){
                cntSum[i] = cntSum[i-1] +1;
            }else {
                cntSum[i] = cntSum[i-1];
            }
        }
        int qs =    queries.length;
        int[] ans = new int[qs];
        for (int i = 0; i < qs; i++) {
            if(queries[i][0] == 0){
                ans[i] = cntSum[queries[i][1]];
            }else {
                ans[i] = cntSum[queries[i][1]] -cntSum[queries[i][0]-1];
            }
        }
        return ans;
    }

    boolean check(String word){
        char c  = word.charAt(0);
        char c2 = word.charAt(word.length()-1);
        if((c == 'a' || c == 'e' ||c == 'u' ||c == 'i' ||c == 'o' ) &&
                (c2 == 'a' || c2 == 'e' ||c2 == 'u' ||c2 == 'i' ||c2 == 'o') ){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}});
    }

}
