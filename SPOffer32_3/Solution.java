package SPOffer32_3;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int curDequeLength = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 1; i <= curDequeLength ; i++) {
                if(res.size()%2 == 1) //偶数行
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
