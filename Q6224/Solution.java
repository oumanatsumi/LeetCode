package Q6224;

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcdCur = nums[i];
            for (int j = i; j < nums.length; j++) {
                gcdCur = gcd(gcdCur, nums[j]);
                if(gcdCur < k) break;
                if(gcdCur == k) cnt++;
            }
        }
        return cnt;
    }

    private int gcd(int a, int b) {
        int rem = 0;
        while (b != 0) {
            rem= a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.subarrayGCD(new int[]{3,12,9,6},3);
    }
}
