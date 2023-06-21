package Q78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void backTrack(List<Integer> tmp, int[] nums, int index){
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(new ArrayList<>(), nums, 0);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.subsets(new int[]{1,2,3});
    }
}
