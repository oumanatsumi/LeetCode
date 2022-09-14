package Q670;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Solution {
    public int maximumSwap(int num) {
        int n = num;
        if(num <= 11) return num;
        List<Integer> nums = new ArrayList<>();
        List<Integer> numsCopy = new ArrayList<>();;
        while(num >0){
            nums.add(0,num%10);
            numsCopy.add(0,num%10);
            num /= 10;
        }

        Collections.sort(nums, Collections.reverseOrder());

        int index=-1;
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) != numsCopy.get(i)){
                index = i;
                break;
            }
        }
        if(index == -1) return n;
        int small = numsCopy.get(index);
        int big = nums.get(index);
        for(int i = numsCopy.size()-1; i>=0 ;i--){
            if(numsCopy.get(i) == big){
                numsCopy.set(i,small);
                numsCopy.set(index,big);
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < numsCopy.size(); i++) {
            ans = ans + numsCopy.get(i) * (int)Math.pow((double)10,(double)numsCopy.size()-i-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.maximumSwap(9973);
        System.out.println(res);
    }
}
