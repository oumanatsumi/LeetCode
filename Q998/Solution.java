package Q998;

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode father = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < val){
                if(father == null){
                    return new TreeNode(val, root,null);
                }
                else {
                    father.right= new TreeNode(val, cur,null);
                    return root;
                }
            }
            else {
                father = cur;
                cur = cur.right;
            }
        }
        //在右子树的尽头插入
        father.right = new TreeNode(val);
        return root;
    }
}
