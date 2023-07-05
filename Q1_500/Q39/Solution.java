package Q1_500.Q39;

import java.util.*;

class Solution {

    // 记忆化搜索
    List<List<Integer>> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Integer[] nums = new Integer[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            nums[i] = candidates[i];
        }
        dfs(new ArrayList<>(), nums, target, 0,new int[nums.length]);
        return res;
    }

    private void dfs(List<Integer> cur, Integer[] nums, int target, int curSum, int[] map){
        if(curSum == target){
            StringBuilder sb = new StringBuilder();
            for(int i : map){
                sb.append(i).append('#');
            }
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                res.add(new ArrayList<>(cur));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(curSum + nums[i] <= target){
                cur.add(nums[i]);
                map[i] ++;
                dfs(cur , nums, target, curSum + nums[i],map);
                map[i] --;
                cur.remove(cur.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        s.combinationSum(new int[]{3,12,9,11,6,7,8,5,4},15);
        System.out.println(1);
    }
}
