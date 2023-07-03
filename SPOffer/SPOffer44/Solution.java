package SPOffer.SPOffer44;

public class Solution {
    public int findNthDigit(int n) {
        if(n < 10) return n;
        n -= 10;
        int len = 2;
        while (len < 11){
            int curSize = (int) (len * 9 * Math.pow(10, len-1));
            if(n <  curSize){
                int index = n / len + (int)Math.pow(10, len-1);
                int diff = n % len;
                index /= (int)Math.pow(10, len - diff - 1);
                return index % 10;
            }else {
                len++;
                n -= curSize;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNthDigit(10));
    }
}
