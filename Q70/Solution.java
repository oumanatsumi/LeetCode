package Q70;

public class Solution {
//    public int climbStairs(int n) {
//        if(n%2==1)
//        {
//            return 1<<((n-1)/2) +1;
//        }
//        else
//        {
//            return 1<<(n/2);
//        }
//    }

    public int climbStairs(int n) {
        int t1 = 1, t2 = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            int temp = t1 + t2;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }
}
