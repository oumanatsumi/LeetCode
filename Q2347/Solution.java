package Q2347;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        boolean flag1 = true;
        for (int i = 1; i < 5 ; i++) {
            if(suits[i] != suits[i-1]){
                flag1 = false;
                break;
            }
        }
        if(flag1) return "Flush";
        int[] map = new int[14];
        for(int i : ranks){
            map[i]++;
        }
        for (int i = 0; i < 14; i++) {
            if(map[i] >= 3){
                return "Three of a Kind";
            }
        }
        for (int i = 0; i < 14; i++) {
            if(map[i] == 2){
                return "Pair";
            }
        }
        return "High Card";
    }
}
