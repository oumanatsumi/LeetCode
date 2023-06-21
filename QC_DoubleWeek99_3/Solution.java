package QC_DoubleWeek99_3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int MOD = 1000000007;
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        int cnt = 1, curRight = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if(curRight >= ranges[i][0]) // 有重叠
            {
                curRight = Math.max(curRight,ranges[i][1]);
            }
            else
            {
                cnt ++;
                curRight = ranges[i][1];
            }
        }
        return PowerMod(2,cnt,MOD);
    }

    int PowerMod (long a,int b,int c)
    {
        long  ans = 1;
        a = a % c;
        while (b > 0) {
            if(b % 2 == 1)
            ans = (ans * a) % c;
            b = b / 2;       //b >>= 1;
            a = (a * a) % c;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.countWays(new int[][]{
                {34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}
        });
        System.out.println(res);
    }
}
