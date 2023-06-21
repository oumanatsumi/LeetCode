package SPOffer.SPOffer66;

class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        if(a.length == 0) return a;
        if(a.length == 1) return new int[]{0};
        left[0] = a[0];
        right[n-1] = a[n-1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * a[i];
        }
        for (int i = n-2; i > 0 ; i--) {
            right[i] = right[i+1] * a[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = 1;
            if(i!=0) res[i] *= left[i-1];
            if(i!=n-1) res[i] *= right[i+1];
        }
        return res;
    }
}
