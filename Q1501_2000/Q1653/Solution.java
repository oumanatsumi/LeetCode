package Q1501_2000.Q1653;

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        a[n-1] = s.charAt(n-1) == 'a' ? 1:0;
        for (int i = n-2; i >=0 ; i--) {
            a[i] = s.charAt(i) == 'a' ? a[i+1] +1 :a[i+1];
        }
        b[0] = s.charAt(0) == 'b' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            b[i] = s.charAt(i) == 'b' ? b[i-1] +1 :b[i-1];
        }


        int min = Math.min(b[0], a[n-1]);
        for (int i = 1; i < n; i++) {
            min = Math.min(min, a[i] + b[i-1]);
        }
        return min;

    }
}
