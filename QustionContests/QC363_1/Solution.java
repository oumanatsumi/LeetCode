package QustionContests.QC363_1;

import java.util.List;

public class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int j = i;
            int cnt = 0;
            while (j > 0){
                if((j & 1) == 1) cnt ++;
                j = j >> 1;
            }
            if(k == cnt) res += nums.get(i);
        }
        return res;
    }
}
