package SPOffer67;

class Solution {
    public int strToInt(String str) {
        str = str.trim();
        if(str.length() == 0 || ((str.charAt(0) <'0' || str.charAt(0) >'9') && str.charAt(0) != '+' && str.charAt(0) !='-')){
            return 0;
        }
        char[] cs = str.toCharArray();
        int index = 0;
        boolean positive = true;
        if(cs[index] == '-') {
            positive = false;
            index ++;
        }else if(cs[index] == '+'){
            index ++;
        }
        StringBuilder sb = new StringBuilder();
        while (index < cs.length && cs[index] >='0' && cs[index] <= '9'){
            if(sb.length() == 0 && cs[index] == '0'){
                index++;
            }else {
                sb.append(cs[index++]);
            }
        }
        if(sb.length() == 0) return 0;
        if(sb.length() > 10){
            if(positive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        long res = Long.parseLong(sb.toString());
        if(res > Integer.MAX_VALUE){
            if(positive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }else {
            if(positive) return (int) res;
            else return -(int) res;
        }
    }
}
