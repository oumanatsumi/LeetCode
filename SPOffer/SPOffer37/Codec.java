package SPOffer.SPOffer37;

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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
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
        if(data.equals("")) return null;
        String[] datas= data.split(",");
        int[] nullCnt = new int[datas.length];
        nullCnt[0] = 0;
        for (int i = 1; i < nullCnt.length; i++) {
            if(datas[i].equals("null")) nullCnt[i] = nullCnt[i-1]+1;
            else nullCnt[i] = nullCnt[i-1];
        }
        TreeNode[] nodes = new TreeNode[datas.length];
        for (int i = 0; i < datas.length; i++) {
            if(datas[i].equals("null")){
                nodes[i] = null;
            }else {
                nodes[i] = new TreeNode(Integer.parseInt(datas[i]));
            }
        }
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        while (!dq.isEmpty()){
            int index = dq.pop();
            if(!datas[index].equals("null")){
                int leftIndex = 2*(index-nullCnt[index])+1;
                if(leftIndex < datas.length){
                    dq.offerLast(leftIndex);
                    nodes[index].left = nodes[leftIndex];
                }
                int rightIndex = 2*(index-nullCnt[index])+2;
                if(rightIndex < datas.length){
                    dq.offerLast(rightIndex);
                    nodes[index].right = nodes[rightIndex];
                }
            }
        }
        return nodes[0];
    }
}
