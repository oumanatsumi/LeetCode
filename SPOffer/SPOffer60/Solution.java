package SPOffer.SPOffer60;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] dicesProbability(int n) {
        int[] map = new int[67];
        for (int j = 1; j <= 6; j++) {
            map[j] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] newMap = new int[67];
            for (int j = 60; j >= 0; j--) {
                while (map[j] > 0){
                    for (int k = 1; k <= 6; k++) {
                        newMap[j+k] ++;
                    }
                    map[j]--;
                }
            }
            map = newMap;
        }

        List<Double> list = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < 67; i++) {
            pos += map[i];
        }
        for (int i = 0; i < 67; i++) {
            if(map[i] > 0){
                list.add(map[i] /(double) pos);
            }
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.dicesProbability(3);
    }
}
