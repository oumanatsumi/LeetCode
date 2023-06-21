package Q1001_1500.Q1460;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        for (int i : target) {
            map[i] += 1 ;
        }
        for (int i : arr) {
            map[i]--;
            if (map[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
