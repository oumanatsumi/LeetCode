package Q1145;

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

public class Solution {
    TreeNode firstPlayer;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        search(root, x);
        int leftLen = dfs(firstPlayer.left);
        int rightLen = dfs(firstPlayer.right);
        return leftLen > n/2 || rightLen > n/2 || (n-1-leftLen-rightLen) > n/2;
    }

    void search(TreeNode root, int x){
        if(root == null) return;
        else if(root.val == x){
            firstPlayer = root;
            return;
        }
        search(root.left,x);
        search(root.right,x);
    }

    int dfs(TreeNode root){
        if(root == null) return 0;
        else return dfs(root.left)+ dfs(root.right)+1;
    }
}
