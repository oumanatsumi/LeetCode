package QC350_1;

public class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int des = 0, flag = 0;
        while (mainTank > 0){
            des += 10;
            mainTank --;
            flag ++;
            if(flag % 5 == 0 && additionalTank > 0){
                additionalTank -- ;
                mainTank ++;
            }
        }
        return des;
    }
}
