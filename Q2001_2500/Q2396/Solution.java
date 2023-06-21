package Q2001_2500.Q2396;

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n-2 ; i++) {
            if(!check(calc(n,i))){
                return false;
            }
        }
        return true;
    }

    private boolean check(String num){
        StringBuilder sb = new StringBuilder(num);
        if(sb.reverse().toString().equals(num)) {
            return true;
        }else {
            return false;
        }
    }

    private String calc(int num, int jinzhi){
        String res = "";
        while(num >0){
            int temp = num % jinzhi;
            res = temp + res;
            num = num / jinzhi;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isStrictlyPalindromic(5));
    }

}
