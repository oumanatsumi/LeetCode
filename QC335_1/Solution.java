package QC335_1;

public class Solution {
    public int passThePillow(int n, int time) {
        int oneRound = n - 1;
        int d = time / oneRound;
        int y = time % oneRound;
        if(d %2  == 0){
            return y + 1;
        }
        else {
            return n -y;
        }
    }
}
