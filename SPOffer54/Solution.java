package SPOffer54;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {

   public int kthLargest(TreeNode root, int k) {
        List<Integer > res = new ArrayList<>();
        dfs(res,root);
        return res.get(res.size()-k);
   }

   private void dfs(List<Integer> res, TreeNode root){
       if(root == null) return;
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
   }
}
