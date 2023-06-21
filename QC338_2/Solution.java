package QC338_2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;

        List<Integer> getPrime = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            int lim = (int) Math.sqrt(i);
            boolean flag = true;
            for (int j = 2; j <= lim; j++) {
                if(i % j == 0 && i != j){
                    flag = false;
                    break;
                }
            }
            if(flag){
                getPrime.add(i);
            }
        }

        int m = getPrime.size();
        for (int i = n-2; i >= 0; i--) {
            boolean flag = false;
            if(nums[i+1] > nums[i]) continue;
            else {
                for (int j = 0; j < m; j++) {
                    if(nums[i] - getPrime.get(j) < nums[i+1]){
                        nums[i] -= getPrime.get(j);
                        if(nums[i] <= 0) return false;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) return false;
        }
        return true;
    }
    
}

