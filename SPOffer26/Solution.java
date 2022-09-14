package SPOffer26;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        String sba = midOrder("",A);
        String sbb = midOrder("",B);

        if(sba.length()==0 || sbb.length()==0){
            return false;
        }
        System.out.println(sba);
        System.out.println(sbb);
        for(int i = 0;i<sba.length()-sbb.length()+1;i++){
            if(sba.substring(i,i+sbb.length()).equals(sbb.toString())){
                return true;
            }
        }
        return false;
    }

    private String midOrder(String s,TreeNode root){
        if(root == null) {
            s += " ";
            return s;
        }
        s = midOrder(s, root.left);
        s += root.val;
        s += "_";
        s = midOrder(s, root.right);
        return s;
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
