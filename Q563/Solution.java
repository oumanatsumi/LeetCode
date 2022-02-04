package Q563;

public class Solution {
    int res= 0;
    public int findTilt(TreeNode root) {
        cul(root);
        return res;
    }



    private int cul(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int sumLeft = cul(root.left);
        int sumRight = cul(root.right);
        res += Math.abs(sumLeft - sumRight);
        return sumLeft+sumRight+root.val;
    }
}
