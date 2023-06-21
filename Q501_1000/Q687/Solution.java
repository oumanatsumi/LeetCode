package Q501_1000.Q687;

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
    int res =0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1=0,right1=0;
        if(root.left != null && root.left.val == root.val){
            left1 = left+1;
        }
        if(root.right != null && root.right.val == root.val){
            right1 = right + 1;
        }
        res = Math.max(res, left1+right1);
        return Math.max(left,right);
    }
}
