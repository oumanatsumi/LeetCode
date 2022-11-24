package Q1742;

public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[50];
        for (int i = lowLimit; i <=highLimit ; i++) {
            cnt[calcBoxIndex(i)]++;
        }
        int max = -1;
        for(int c:cnt){
            max = Math.max(max , c);
        }
        return max;
    }

    private int calcBoxIndex(int n){
        int r = 0;
        while (n > 0){
            r += n % 10;
            n /= 10;
        }
        return r;
    }
}
