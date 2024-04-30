package QustionContests.QC363_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int cnt = 0;
        if(nums.get(0) > 0) cnt++;
        for (int i = 0; i < nums.size()-1; i++) {
            if(i+1 > nums.get(i) && nums.get(i+1) > i+1){
                cnt++;
            }
        }
        if(nums.get(nums.size()-1) < nums.size()) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(0);
        list.add(3);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(7);
        s.countWays(list);
    }
}
