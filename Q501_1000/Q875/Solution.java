package Q501_1000.Q875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0, max = -1, n = piles.length;
        for(int i:piles) {
            sum += i;
            max = Math.max(max, i);
        }
        int l = (int)sum / h , r = max, mid;
        while (l <= r){
            mid = (l+ r) >>> 1;
            int cost = mid, time = 0;
            for(int i: piles){
                time += Math.ceil((double) i / cost);
            }
            if(time <= h){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return Math.min(max, l);
    }
}
