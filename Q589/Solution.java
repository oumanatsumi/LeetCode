package Q589;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        firstOrder(res,root);
        return res;
    }
    private void firstOrder(List<Integer> res ,Node root)
    {
        res.add(root.val);
        if(root.children!=null){
            for(Node child:root.children){
                firstOrder(res,child);
            }
        }
    }
}
