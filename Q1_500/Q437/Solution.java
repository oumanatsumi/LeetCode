package Q1_500.Q437;

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

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return 0;
        }
        int res=0;
        res += dfs(root,targetSum);

        res += pathSum(root.left,targetSum);
        res += pathSum(root.right,targetSum);

        return res;
    }

    int dfs(TreeNode root,int targetSum)
    {
        int num=0;

        if(root == null) {
            return 0;
        }

        if(root.val==targetSum)
        {
            num++;
        }
        num += dfs(root.left,targetSum-root.val);
        num += dfs(root.right,targetSum-root.val);
        return num;
    }


}
