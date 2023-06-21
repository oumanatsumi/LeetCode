package SPOffer.SPOffer55_2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left =dfs(root.left)+1;
        int right = dfs(root.right)+1;
        if(Math.abs(left - right) >1) flag =false;
        return Math.max(left,right);
    }
}
