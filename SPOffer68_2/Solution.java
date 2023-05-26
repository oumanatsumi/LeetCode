package SPOffer68_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    List<Integer> pPath;
    List<Integer> qPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(new ArrayList<>(), root, p, q);
        int l = pPath.size()-1, r = qPath.size() -1;
        while()
    }

    public void dfs(List<Integer> path, TreeNode node, TreeNode p, TreeNode q){
        path.add(node.val);
        if(node.val == p.val){
            Collections.copy(pPath, path);
            return;
        }
        if(node.val == q.val){
            Collections.copy(qPath, path);
            return;
        }
        if(node.left!=null){
            dfs(path, node.left, p ,q);
        }
        if(node.right!=null){
            dfs(path, node.right, p ,q);
        }
    }
}
