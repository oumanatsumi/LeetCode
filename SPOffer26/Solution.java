package SPOffer26;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        if(A.val == B.val && isSubTree(A,B)){
            return true;
        }else {
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
    }

    private boolean isSubTree(TreeNode a,TreeNode b){
        if(b == null) return true;
        else if (a == null) return false;
        else{
            if(a.val != b.val) return false;
            else return isSubTree(a.left,b.left) && isSubTree(a.right,b.right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(3);

        t1.left =t2;
        t1.right=t3;
        t2.left =t4;

        boolean res = s.isSubStructure(t1,t5);
        System.out.println(res);
    }
}
