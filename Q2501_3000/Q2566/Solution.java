package Q2501_3000.Q2566;


class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        char re = '9' ;
        char[] str_c = str.toCharArray();
        for (int i = 0; i < str_c.length; i++) {
            if(str_c[i] != '9'){
                re = str_c[i];
                break;
            }
        }
        int max = 0;
        for (int i = 0; i < str_c.length; i++) {
            if(str_c[i] == re){
                str_c[i] = '9';
            }
        }
        String t = String.valueOf(str_c);
        max = Integer.parseInt(t);

        str_c = str.toCharArray();
        re = str_c[0];
        int min = 0;
        for (int i = 0; i < str_c.length; i++) {
            if(str_c[i] == re){
                str_c[i] = '0';
            }
        }
        String t2 = String.valueOf(str_c);
        min = Integer.parseInt(t2);
        return max - min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minMaxDifference(456);
    }
}