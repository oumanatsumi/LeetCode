package QustionContests.QC339_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        for(int i :nums){
            cnt[i]++;
        }
        int max = IntStream.of(cnt).max().getAsInt();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                if(cnt[j]-- > 0){
                    temp.add(j);
                }
            }
            res.add(temp);
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMatrix(new int[]{1,2,3,4});
    }
}
