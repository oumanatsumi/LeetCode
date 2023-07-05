package Q1_500.Q69;

class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x,mid;
        long tmp;
        while (l <= r){
            mid = (l + r) >>> 1;
            tmp = (long) mid * mid;
            if(tmp == x) return mid;
            else if(tmp > x) r = mid -1;
            else l = mid + 1;
        }
        return r;
    }
}
