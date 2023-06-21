package SPOffer34;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(0,root,target);
        return ans;
    }

    private void dfs(int sum, TreeNode root, int target){
        if(root == null) {
            return;
        }
        temp.add(root.val);
        sum = sum+ root.val;
        if(sum == target && root.left == null && root.right == null){
            ans.add(new ArrayList<>(temp));
        }
        dfs(sum,root.left,target);
        dfs(sum,root.right,target);
        temp.remove(temp.size()-1);
    }

}
