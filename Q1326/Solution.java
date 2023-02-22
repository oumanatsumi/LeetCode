package Q1326;

public class Solution {
    public int minTaps(int n, int[] ranges) {
        // 对于每一个左断点，找到能覆盖到最右的范围， 记到reach数组
        int[] reach = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            reach[Math.max(i - ranges[i], 0)] = Math.max(i + ranges[i],reach[i]);
        }
        int pre= 0,cur = 0,ans = 0;
        for (int i = 0; i < n+1; i++) {
           cur = Math.max(cur, reach[i]);
           if(cur < i) {
               return -1;
           }
           if(pre == i){
               pre = cur;
               ans++;
           }
        }
        return ans;
    }
}
