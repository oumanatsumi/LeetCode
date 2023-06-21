package Q2331;
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

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    boolean dfs(TreeNode root){
        switch (root.val){
            case 0: return false;
            case 1:return true;
            case 2:return dfs(root.left) || dfs(root.right);
            case 3:return dfs(root.left) && dfs(root.right);
        }
        return false;
    }
}
