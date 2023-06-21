package SPOffer32_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int curLevelLength = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 1; i <= curLevelLength; i++) {
                TreeNode top = queue.peek();
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
                level.add(queue.poll().val);
            }
            res.add(level);
        }

        return res;
    }

    //DFS
    // Q102
}
