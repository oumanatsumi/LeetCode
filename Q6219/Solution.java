package Q6219;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0;i<= num;i++){
            if(reverse(i) + i == num){
                return true;
            }
        }
        return false;
    }

    private int reverse(int num){
        List<Integer> nums = new ArrayList<>();
        while (num>0){
            nums.add(0,num % 10);
            num /=10;
        }
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums.get(i)*Math.pow(10,i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumOfNumberAndReverse(0));
    }
}
