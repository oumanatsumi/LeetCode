package QC339_1;

public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        int n = s.length();
        boolean begin0 = false;
        boolean begin1 = false;
        int start0Index = 0, start1Index = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0'){
                begin1 = false;
                if(!begin0) {
                    begin0 = true;
                    start0Index = i;
                }
            }
            else {
                begin0 = false;
                if(!begin1){
                    begin1 = true;
                    start1Index = i;
                }
                max = Math.max(max, Math.min(start1Index - start0Index, i - start1Index + 1));
            }
        }
        return max*2;
    }

    public static void main(String[] args) {
        Solution  s = new Solution();
        int res = s.findTheLongestBalancedSubstring("01000111001001001010000111101000000111000111111");
        System.out.println(res);
    }
}
