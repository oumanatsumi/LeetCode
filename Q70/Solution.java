package Q70;

public class Solution {
    public int climbStairs(int n) {
        if(n%2==1)
        {
            return 1<<((n-1)/2) +1;
        }
        else
        {
            return 1<<(n/2);
        }
    }
}
