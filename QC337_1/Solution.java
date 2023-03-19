package QC337_1;

public class Solution {
    public int[] evenOddBit(int n) {
        String bin = Integer.toBinaryString(n);
        int[] ans = new int[2];
        int len = bin.length();
        for (int i = len-1; i >=0; i--) {
            if(bin.charAt(i) == '1'){
                if((len - i) % 2 == 0) {
                    ans[1]++;
                }else {
                    ans[0]++;
                }
            }
        }
        return ans;
    }
}
