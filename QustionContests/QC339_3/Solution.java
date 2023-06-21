package QustionContests.QC339_3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
        }
        int[][] origin = new int[n][2];
        for (int i = 0; i < n; i++) {
            origin[i][0] = diff[i];
            origin[i][1] = i;
        }
        Arrays.sort(origin, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int res = 0;
        for (int i = 0; i < k; i++) {
            res += reward1[origin[i][1]];
        }
        for (int i = k; i < n; i++) {
            res += reward2[origin[i][1]];
        }
        return res;
    }
}

