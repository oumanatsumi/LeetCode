package Q1_500.Q46;

import java.util.*;

class Solution {
    //
//
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//        List<Integer> output = new ArrayList<>();
//        for(int num:nums)
//        {
//            output.add(num);
//        }
//        int len = nums.length;
//
//        dfs(res,output,0,len);
//        return res;
//    }
//
//    private void dfs(List<List<Integer>> res, List<Integer> output, int first, int len) {
//        if(first == len)
//        {
//            res.add(new ArrayList<>(output));
//            return;
//        }
//        for(int i = first;i<len;i++)
//        {
//            Collections.swap(output,first,i);
//            dfs(res, output, first+1,len);
//            Collections.swap(output,first,i);
//        }
//    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(res, new ArrayList<Integer>(), visited, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int[] visited, int[] nums) {
        if (output.size() == nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            output.add(nums[i]);
            visited[i] = 1;
            dfs(res, output, visited, nums);
            visited[i] = 0;
            output.remove(output.size() - 1);
        }
    }

}
