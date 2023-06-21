package QC_DoubleWeek99_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int splitNum(int num) {
        int[] map = new int[10];
        while (num > 0){
            int tmp = num%10;
            map[tmp]++;
            num /=10;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < map[i]; j++) {
                if(flag){
                    sb1.append(i);
                    flag = false;
                }else {
                    sb2.append(i);
                    flag = true;
                }
            }
        }
        return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }
    

}
