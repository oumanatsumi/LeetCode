package Q652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root){
        if(root == null) return " ";
        String s = String.valueOf(root.val);
        s += "_";
        s += dfs(root.left);
        s += dfs(root.right);
        map.put(s, map.getOrDefault(s,0)+1);
        if(map.get(s) == 2){
            ans.add(root);
        }
        return s;
    }

}
