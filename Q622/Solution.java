package Q622;

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

class Solution {
    //    public int widthOfBinaryTree(TreeNode root) {
////        Queue<TreeNode> queue = new LinkedList<>();
//        Map<TreeNode,Long> numMap = new HashMap<>();
////        queue.offer(root);
//        numMap.put(root, 1L);
//        long maxWidth = 1;
//        List<TreeNode> level = new ArrayList<>();
//        level.add(root);
//        while(!level.isEmpty()){
////          TreeNode top = queue.poll();
//            List<TreeNode> temp = new ArrayList<>();
//            long min= Long.MAX_VALUE,max = 0;
//            for(TreeNode top:level)
//            {
//                if(top.left != null){
//                    temp.add(top.left);
//                    numMap.put(top.left, 2*numMap.get(top));
//                    min = Math.min(2*numMap.get(top), min);
//                    max = Math.max(2*numMap.get(top), max);
//                }
//                if(top.right != null){
//                    temp.add(top.right);
//                    numMap.put(top.right, 2*numMap.get(top)+1);
//                    min = Math.min(2*numMap.get(top)+1, min);
//                    max = Math.max(2*numMap.get(top)+1, max);
//                }
//            }
//            maxWidth = Math.max(max-min+1 , maxWidth);
//            level.clear();
//            level.addAll(temp);
//        }
//        return (int)maxWidth;
//    }
    Map<Integer, Integer> levelMin = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode root, int depth, int code){
        if(root == null){
            return 0;
        }
        levelMin.putIfAbsent(depth, code);
        int childMax = Math.max(dfs(root.left, depth+1, code*2),
                dfs(root.right,depth+1,code*2+1));
        return Math.max(code - levelMin.get(depth)+1, childMax);
    }

}
