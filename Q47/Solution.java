package Q47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Set<String> all = new HashSet<>();
        dfs(res, new ArrayList<Integer>(), visited, nums, all);


        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int[] visited, int[] nums,Set<String> all){
        if(output.size() == nums.length){
            String tmp = "";
            for(int i :output){
                tmp += i;
            }
            if(!all.contains(tmp)){
                all.add(tmp);
                res.add(new ArrayList<>(output));
            }
            return;
        }
        for(int i = 0;i< nums.length;i++){
            if(visited[i] == 1) continue;
            output.add(nums[i]);
            visited[i] = 1;
            dfs(res, output,visited,nums,all);
            visited[i] = 0;
            output.remove(output.size()-1);
        }
    }
}
