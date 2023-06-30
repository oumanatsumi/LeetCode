package Q2001_2500.Q2305;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int k;
    Integer[] cookies;
    public int distributeCookies(int[] cookies, int k) {
        this.k = k;
        Arrays.sort(cookies);
        this.cookies = new Integer[cookies.length];
        for (int i = 0; i < cookies.length; i++) {
            this.cookies[cookies.length - i -1] = cookies[i];
        }
        return dfs(new int[k], 0);
    }

    private int dfs(int[] curValue, int index){
        int min = Integer.MAX_VALUE;
        if(index == cookies.length){
            int max = -1;
            for(int val: curValue){
                max = Math.max(max, val);
            }
            return max;
        }
        // 剪枝1
        int zeroCnt = 0;
        for(int val: curValue){
            if(val == 0) zeroCnt++;
        }
        if(zeroCnt > cookies.length - index) return min;
        // 剪枝3
        if(index == 0){
            curValue[0] += cookies[index];
            min = Math.min(min, dfs(curValue, index+1));
        }else {
            for (int i = 0; i < k; i++) {
                curValue[i] += cookies[index];
                // 剪枝2
                if(curValue[i] <= min){
                    min = Math.min(min, dfs(curValue, index+1));
                }
                curValue[i] -= cookies[index];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.distributeCookies(new int[]{13,3},2);
        System.out.println(res);
    }
}
