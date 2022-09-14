package Q102;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //DFS
    // BFS在剑指offer32-2

    Map<Integer,List<Integer>> depthMap = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,0);
        for(Integer i:depthMap.keySet()){
            res.add(depthMap.get(i));
        }
        return res;
    }

    private void dfs(TreeNode root, int depth){
        if(root== null) return;
        dfs(root.left,depth+1);

        if(!depthMap.containsKey(depth)){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            depthMap.put(depth , temp);
        }else {
            List<Integer> temp = depthMap.get(depth);
            temp.add(root.val);
            depthMap.put(depth,temp);
        }
        dfs(root.right,depth+1);
    }
}
