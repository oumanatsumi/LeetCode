package Q1796;

class Solution {
    public int secondHighest(String s) {
        int[] map = new int[10];
        for(char c: s.toCharArray()){
            if(c >= '0' && c <= '9') map[c-'0']++;
        }
        boolean flag = false;
        for (int i = 9; i >= 0 ; i--) {
            if(!flag && map[i]!=0) flag = true;
            else if(flag && map[i]!=0) return i;
        }
        return -1;
    }
}
