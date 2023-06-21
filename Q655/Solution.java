package Q655;


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
    int row, col, height = 0;

    public List<List<String>> printTree(TreeNode root) {
        calcHeight(root, height);
        row = height + 1;
        col = (1 << (height + 1)) - 1;

        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < row; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        dfs(res, root, 0, (col - 1) / 2);
        return res;
    }

    private void calcHeight(TreeNode root, int height) {
        this.height = Math.max(this.height, height);
        if (root.left != null) {
            calcHeight(root.left, height + 1);
        }
        if (root.right != null) {
            calcHeight(root.right, height + 1);
        }
    }

    private void dfs(List<List<String>> res, TreeNode root, int row, int center) {
        res.get(row).set(center, Integer.toString(root.val));
        if (root.left != null) {
            dfs(res, root.left, row + 1, center - (1 << (height - row - 1)));
        }
        if (root.right != null) {
            dfs(res, root.right, row + 1, center + (1 << (height - row - 1)));
        }
    }

}