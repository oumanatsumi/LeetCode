package SPOffer.SPOffer43;

class Solution {
    public int countDigitOne(int n) {
            return n < 10 ? (n == 0 ? 0 : 1) : (int)(n / (int) Math.pow(10, (int) Math.ceil(Math.log10(n + 1)) - 1)) *
                    ((int) Math.ceil(Math.log10(n + 1)) - 1) * (int) Math.pow(10, (int) Math.ceil(Math.log10(n + 1)) -2) +
                    countDigitOne(n % (int) Math.pow(10, (int) Math.ceil(Math.log10(n + 1)) -1)) +
                    ((int)(n / (int) Math.pow(10, (int) Math.ceil(Math.log10(n + 1)) - 1)) == 1 ? n % (int) Math.pow(10,  (int) Math.ceil(Math.log10(n + 1)) -1) + 1 :
                    (int) Math.pow(10, (int) Math.ceil(Math.log10(n + 1)) - 1));

//        if(n < 10) return n == 0 ? 0 : 1;
//        int x = (int) Math.ceil(Math.log10(n + 1));
//        int left = n % (int) Math.pow(10, x -1);
//        int highBit = n / (int) Math.pow(10, x - 1);
//        int res = 0;
//        if(highBit != 1){
//            res += (int) Math.pow(10, x - 1);
//        }else {
//            res += left + 1;
//        }
//        res += highBit * (x - 1) * (int) Math.pow(10, x -2) ;
//        res += countDigitOne(left);
//        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countDigitOne(13));
    }
}
