package Q654;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode();
        return dfs(root,nums,0,nums.length-1);
    }

    private TreeNode dfs(TreeNode root, int[] nums, int left, int right){
        int rootIndex = getLocalMaxIndex(nums, left, right);
        root.val = nums[rootIndex];
        if(left < rootIndex){
            root.left = dfs(new TreeNode(), nums, left, rootIndex-1);
        }
        if(right > rootIndex){
            root.right = dfs(new TreeNode(),nums, rootIndex+1,right);
        }
        return root;
    }

    private int getLocalMaxIndex(int[] nums, int left,int right)
    {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
