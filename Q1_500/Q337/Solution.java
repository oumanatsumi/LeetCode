package Q1_500.Q337;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Solution {
    public int rob(TreeNode root) {
        dfs(root);
        return root.val;
    }

    private void dfs(TreeNode root){
        if(root.left == null && root.right == null) return;
        int sonSum = 0;
        int grandSonSum = 0;
        if(root.left != null){
            dfs(root.left);
            sonSum += root.left.val;
            if(root.left.left!=null){
                grandSonSum += root.left.left.val;
            }
            if(root.left.right!=null){
                grandSonSum += root.left.right.val;
            }
        }
        if(root.right != null){
            dfs(root.right);
            sonSum += root.right.val;
            if(root.right.left!=null){
                grandSonSum += root.right.left.val;
            }
            if(root.right.right!=null){
                grandSonSum += root.right.right.val;
            }
        }
        root.val = Math.max(root.val + grandSonSum, sonSum);
    }
}
