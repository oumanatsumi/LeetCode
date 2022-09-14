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
        StringBuilder sba = new StringBuilder("");
        StringBuilder sbb = new StringBuilder("");
        midOrder(sba,A);
        midOrder(sbb,B);
        System.out.println(sba);
        System.out.println(sbb);
        for(int i = 0;i<sba.length()-sbb.length();i++){
            if(sba.substring(i,i+sbb.length()).equals(sbb)){
                return true;
            }
        }
        return false;
    }

    private void midOrder(StringBuilder s,TreeNode root){
        if(root == null) {
            s.append(" ");
            return;
        }
        midOrder(s, root.left);
        s.append(root.val);
        s.append("_");
        midOrder(s, root.right);
    }
}
