package QustionContests.QC335_3;

class Solution {

    public int findValidSplit(int[] nums) {
        int n = nums.length,split = 0;
        if(n == 1) return -1;
        long[] leftMuls = new long[n];
        long[] rightMuls = new long[n];
        leftMuls[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMuls[i] = leftMuls[i-1] * nums[i];
        }
        rightMuls[n-1] = nums[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            rightMuls[i] = rightMuls[i+1]*nums[i];
        }
        long left = 0;
        long right = 0;
        while (split < n -1){
            left = leftMuls[split];
            right = rightMuls[split+1];
            if(SteinGCD(left,right) == 1) return split;
            split++;
        }
        return -1;
    }

    long SteinGCD(long a, long b)
    {
        int acc = 0;
        while ((a & 1) == 0 && (b & 1) == 0)
        {
            acc++;
            a >>= 1;
            b >>= 1;
        }
        while ((a & 1) == 0) a >>= 1;
        while ((b & 1) == 0) b >>= 1;
        if (a < b) { long t = a; a = b; b = t; }
        while ((a = (a - b) >> 1) != 0) {
            while ((a & 1) == 0) a >>= 1;
            if (a < b) { long t = a; a = b; b = t; }
        }
        return b << acc;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.findValidSplit(new int[]{4,7,15,8,3,5});
        System.out.println(res);
        System.out.println(s.SteinGCD(4,9));
    }
}
