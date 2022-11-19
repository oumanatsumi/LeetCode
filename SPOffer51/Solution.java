package SPOffer51;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int n;
    public int reversePairs(int[] nums) {
        n = nums.length;
        int[] tree = discretization(nums);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            add(tree,nums[i]);
            sum += query(tree, nums[i]);
        }
    }

    private int[] discretization(int[] arr){
        int[][] arr_ = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr_[i][0] = arr[i];
            arr_[i][1] = i;
        }
        Arrays.sort(arr_, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr_[i][1];
        }
        return ret;
    }

    private int lowBit(int x){
        return x & (-x);
    }

    private void add(int[] arr, int x){
        for (int i = x; i < n; i= i+lowBit(i)) {
            arr[i]++;
        }
    }
    private int query(int[] arr, int x){
        int ret = 0;
        for (int i = x; i > 0; i=i-lowBit(i)) {
            ret += arr[i];
        }
        return ret;
    }
}
