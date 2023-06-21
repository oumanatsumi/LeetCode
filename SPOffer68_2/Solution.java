package SPOffer68_2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 方法一： 递归求出路径

//class Solution {
//    List<TreeNode> pPath = new ArrayList<>();
//    List<TreeNode> qPath = new ArrayList<>();
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(new ArrayList<>(), root, p, q);
//        int index = 0;
//        TreeNode res = null;
//        while(index < pPath.size() && index < qPath.size()){
//            if(pPath.get(index).val == qPath.get(index).val){
//                res = pPath.get(index);
//            }
//            index ++;
//        }
//        return res;
//    }
//
//    public void dfs(List<TreeNode> path, TreeNode node, TreeNode p, TreeNode q){
//        if(pPath.size() > 0 && qPath.size() > 0) return;
//        path.add(node);
//        if(node.val == p.val){
//            for(TreeNode enode: path){
//                pPath.add(enode);
//            }
//        }
//        if(node.val == q.val){
//            for(TreeNode enode: path){
//                qPath.add(enode);
//            }
//        }
//        if(node.left!=null){
//            dfs(path, node.left, p ,q);
//        }
//        if(node.right!=null){
//            dfs(path, node.right, p ,q);
//        }
//        path.remove(path.size()-1);
//    }
//}

// 方法二： 递归直接找
//class Solution {
//    public TreeNode ans = null;
//
//    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
//        if(root == null) return false;
//        boolean lson = dfs(root.left, p ,q);
//        boolean rson = dfs(root.right, p ,q);
//
//        if((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)){
//            ans = root;
//        }
//        return lson || rson || (root.val == p.val || root.val == q.val);
//
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p ,q);
//        return ans;
//    }
//}

// 方法三： 记录父节点
class Solution {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            parents.put(root.left, root);
            dfs(root.left);
        }
        if(root.right != null){
            parents.put(root.right, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null){
            visited.add(p.val);
            p = parents.get(p);
        }
        while (q != null){
            if(visited.contains(q.val)){
                return q;
            }else {
                q = parents.get(q);
            }
        }
        return root;
    }
}