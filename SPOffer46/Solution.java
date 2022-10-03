package SPOffer46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int translateNum(int num) {
        if(num == 0) return 1;
        List<Integer> nums = new ArrayList<>();
        while (num > 0){
            nums.add(0,num%10);
            num /= 10;
        }
        int[] dp = new int[nums.size()];
        dp[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) * 10 + nums.get(i) >= 10 && nums.get(i-1) * 10 + nums.get(i) < 26){
                if(i<2){
                    dp[i] = dp[i-1]+1;
                }else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.size()-1];
    }
}
