package SPOffer49;

public class Solution {
    public int nthUglyNumber(int n) {
        int l = 1,r = n * 5;
        while (l <= r){
            int mid = (l + r) >>> 1;
            int cnt = mid / 2 + mid / 3 + mid / 5 - mid / 6 - mid /10 - mid / 15 + mid / 30;
            if(cnt < n){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return r + 1;
    }
}
