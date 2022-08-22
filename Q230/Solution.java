package Q230;

import java.net.Socket;
import java.util.*;

/**
 * @author Ouma Natsumi
 */
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        nums = traverse(root,nums);
        return nums.get(k-1);
    }

    public List<Integer> traverse(TreeNode root, List<Integer> nums)
    {
        if(root != null)
        {
            traverse(root.left,nums);
            nums.add(root.val);
            traverse(root.right,nums);
        }
        return nums;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode4;

        int res = s.kthSmallest(treeNode1,1);
        System.out.println(res);
    }
}
