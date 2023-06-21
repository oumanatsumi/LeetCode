package SPOffer.SPOffer17;

class Solution {
    public int[] printNumbers(int n) {
        int cnt = (int) Math.pow(10,n)-1;
        int[] res = new int[cnt];
        for (int i = 1; i <=cnt ; i++) {
            res[i-1] = i;
        }
        return res;
    }
}
