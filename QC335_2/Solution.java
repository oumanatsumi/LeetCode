package QC335_2;

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o2 > o1) return 1;
                else return -1;
            }
        });

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //存放遍历结果，然后返回
        int size = queue.size();
        long temp = 0;
        while (!queue.isEmpty()) {
            temp = 0;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                temp += treeNode.val;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            priorityQueue.offer(temp);
        }
        if(priorityQueue.size() < k) return -1;
        else {
            for (int i = 0; i < k-1; i++) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();

    }



}
