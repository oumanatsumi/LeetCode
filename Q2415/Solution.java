package Q2415;


import java.util.*;

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
    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<Integer>> levelOrderRes = levelOrder(root);
        TreeNode newRoot = new TreeNode(levelOrderRes.get(0).get(0));
        createTree(newRoot,levelOrderRes,0,0);
        return newRoot;
    }

    private void createTree(TreeNode root, List<List<Integer>> order, int level , int index){
        if(level < order.size()-1){
            root.left = new TreeNode(order.get(level+1).get(index*2));
            root.right = new TreeNode(order.get(level+1).get(index*2+1));
            createTree(root.left,order,level+1,index*2);
            createTree(root.right,order,level+1,index*2+1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int curDequeLength = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 1; i <= curDequeLength ; i++) {
                if(res.size()%2 == 1)
                {
                    level.offerFirst(queue.peek().val);
                }else
                {
                    level.offerLast(queue.peek().val);
                }

                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
            res.add((List<Integer>) level);
        }
        return res;
    }
}
