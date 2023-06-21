package QustionContests.QC342_4;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // 判断能否全变为1:
        int tmp = gcd(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            tmp = gcd(tmp, nums[i]);
        }
        if(tmp != 1) return -1;

        int[][] gcds = new int[n-1][2];

        int oneCnt = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) oneCnt++;
        }
        int steps = 0;
        for (int i = 0; i < n-1; i++) {
            gcds[i][0] = gcd(nums[i], nums[i+1]);
            gcds[i][1] = i;
        }

        while (oneCnt < n){
            Arrays.sort(gcds, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int k = 0;
            while(nums[gcds[k][1]] == 1 && nums[gcds[k][1]+1] == 1){
                k++;
            }
            int curGcd = gcds[k][0];
            int curIndex = gcds[k][1];
            if(nums[curIndex] > nums[curIndex+1]){
                nums[curIndex] = curGcd;
                for (int i = 0; i < n-1; i++) {
                    if(gcds[i][1] == curIndex-1){
                        gcds[i][0] = gcd(nums[curIndex-1], nums[curIndex]);
                    }
                }
            }else {
                nums[curIndex+1] = curGcd;
                for (int i = 0; i < n-1; i++) {
                    if(gcds[i][1] == curIndex+1){
                        gcds[i][0] = gcd(nums[curIndex+1], nums[curIndex+2]);
                    }
                }
            }
            if(curGcd == 1) oneCnt++;
            steps++;
        }
        return steps;
    }

    private int gcd(int a,int b){
        int k = 0;
        do {
            k = a % b;// 得到余数
            a = b;// 根据辗转相除法,把被除数赋给除数
            b = k;// 余数赋给被除数
        } while (k != 0);
        return a;// 返回被除数
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minOperations(new int[]{4,2,6,3});
        System.out.println(res);
    }
}
