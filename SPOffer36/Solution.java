package SPOffer36;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    List<Node> nodes = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        mid(root);
        if(nodes.size() == 1){
            root.left = root;
            root.right = root;
            return root;
        }
        for (int i = 1; i < nodes.size()-1; i++) {
            nodes.get(i).left = nodes.get(i-1);
            nodes.get(i).right = nodes.get(i+1);
        }
        nodes.get(0).left = nodes.get(nodes.size()-1);
        nodes.get(0).right = nodes.get(1);
        nodes.get(nodes.size()-1).right = nodes.get(0);
        nodes.get(nodes.size()-1).left = nodes.get(nodes.size()-2);
        return nodes.get(0);
    }

    private void mid(Node root){
        if(root == null) return;
        mid(root.left);
        nodes.add(root);
        mid(root.right);
    }
}
