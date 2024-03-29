package QustionContests.QC345_2;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int cur = 0, n = derived.length;
        for (int i = 0; i < n; i++) {
            cur ^= derived[i];
        }
        if(cur == 0) return true;
        cur = 1;
        for (int i = 0; i < n; i++) {
            cur ^= derived[i];
        }
        if(cur == 1) return true;
        else return false;
    }
}
