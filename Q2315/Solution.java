package Q2315;

public class Solution {
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


