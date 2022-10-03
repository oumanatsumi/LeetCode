package SPOffer28;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    private boolean dfs(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        else if(t1 == null || t2 == null) return false;
        else return t1.val == t2.val && dfs(t1.left,t2.right) && dfs(t1.right,t2.left);
    }
}
