package Q1_500.Q278;

class Solution {
    private boolean isBadVersion(int i) {
        return true;
    }

    public int firstBadVersion(int n) {
        int l = 0, r = n,mid;
        while (l <= r){
            mid = (l+r)>>>1;
            if(isBadVersion(mid)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
