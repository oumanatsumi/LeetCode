package SPOffer55_1;

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
   public int maxDepth(TreeNode root) {
      return root == null ? 0 : Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
   }

}
