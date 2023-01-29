package Q6339;

import java.util.Arrays;

public class Solution {

    // 方法1:深搜 TLE

//    int n ;
//    long max = -1,min = Integer.MAX_VALUE;
//    public long putMarbles(int[] weights, int k) {
//        n = weights.length;
//        if(k == 1 || n == k) return 0;
//        dfs(weights, 0, k, 0);
//        return max - min;
//    }
//
//    private void dfs(int[] weights, int start,int k,long sum){
//        if(k == 1){
//            sum += weights[start] + weights[n-1];
//            max = Math.max(sum,max);
//            min = Math.min(sum,min);
//            return;
//        }
//        int end = start;
//        while (n - end >= k){
//            dfs(weights, end+1, k-1, sum + weights[start] +weights[end]);
//            end++;
//        }
//    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k == 1 || n == k) return 0;
        int[] tmp = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            tmp[i] = weights[i]+weights[i+1];
        }
        Arrays.sort(tmp);
        long big = 0, small = 0;
        for (int i = 0; i < k-1; i++) {
            small += tmp[i];
            big += tmp[n - i -2];
        }
        return big - small;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long res = s.putMarbles(new int[]{1,4,2,5,2},3);
        System.out.println(res);
    }
}
