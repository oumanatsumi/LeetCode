package SPOffer7;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder ,int preLeft, int preRight,
                                 int midLeft, int midRight){
        if(midLeft< 0 || midRight>preorder.length || midLeft > midRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        int midRootIndex = map.get(rootVal);
        int leftCount = midRootIndex - midLeft;
        int rightCount = midRight - midRootIndex;
        TreeNode root = new TreeNode(rootVal);
        root.left = myBuildTree(preorder,inorder,preLeft+1, preLeft+leftCount,midLeft,midRootIndex-1);
        root.right = myBuildTree(preorder,inorder,preLeft+leftCount+1, preRight,midRootIndex+1,midRight);
        return root;
    }
}
