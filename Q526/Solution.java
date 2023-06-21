package Q526;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int res = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int[] visited = new int[nums.length];
        dfs(new ArrayList<Integer>(), visited, nums);
        return res;
    }


    private void dfs(List<Integer> output, int[] visited, int[] nums) {
        if (output.size() == nums.length) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0 && (nums[i] % (output.size()+1) == 0 || (output.size()+1) % nums[i]== 0)){
                visited[i] = 1;
                output.add(nums[i]);
                dfs(output, visited, nums);
                visited[i] = 0;
                output.remove(output.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countArrangement(11));
    }
}
