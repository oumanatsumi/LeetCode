package Q2001_2500.Q2315;

class Solution {
    public int countAsterisks(String s) {
        boolean flag = true;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '|') flag = !flag;
            else {
                if(flag && c == '*') cnt++;
            }
        }
        return cnt;
    }
}


