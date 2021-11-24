package Q46;

import java.util.*;

public class Solution {

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        Stack<Integer> output = new Stack<>();
//        int len = nums.length;
//        boolean[] used = new boolean[len];
//
//        dfs(nums,used,res,output,0,len);
//        return res;
//    }
//
//    private void dfs(int[] nums,boolean[] used,List<List<Integer>> res, Stack<Integer> output, int depth, int len) {
//        if(output.size() == len)
//        {
//            res.add(new ArrayList<>(output));
//            return;
//        }
//        for(int i = 0;i<len;i++)
//        {
//            if(!used[i])
//            {
//                output.push(nums[i]);
//                used[i] = true;
//                dfs(nums,used,res,output,depth+1,len);
//                output.pop();
//                used[i] = false;
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<>();
        for(int num:nums)
        {
            output.add(num);
        }
        int len = nums.length;

        dfs(res,output,0,len);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int first, int len) {
        if(first == len)
        {
            res.add(new ArrayList<>(output));
            return;
        }
        for(int i = first;i<len;i++)
        {
            Collections.swap(output,first,i);
            dfs(res, output, first+1,len);
            Collections.swap(output,first,i);
        }
    }

}
