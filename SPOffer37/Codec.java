package SPOffer37;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        String res = "";
        while (!dq.isEmpty()){
            TreeNode temp = dq.pop();
            if(temp.val == -1001){
                res += "null,";
                continue;
            }else {
                res += (temp.val+",");
            }
            if(temp.left == null){
                dq.offerLast(new TreeNode(-1001));
            }else {
                dq.offerLast(temp.left);
            }
            if(temp.right == null){
                dq.offerLast(new TreeNode(-1001));
            }else {
                dq.offerLast(temp.right);
            }
        }
        return res.substring(0,res.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas= data.split(",");
        Deque<TreeNode> dq = new LinkedList<>();

    }
}
