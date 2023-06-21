package Q501_1000.Q559;

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
}
class Solution {
    int max = 0;
    public int maxDepth(Node root) {
        if(root==null)
        {
            return 0;
        }
        dfs(root,1);
        return max;
    }

    void dfs(Node root,int curDepth)
    {
        max = Math.max(curDepth,max);
        if(root.children!=null)
        {
            for(int i=0;i<root.children.size();i++)
            {
                dfs(root.children.get(i),curDepth+1);
            }
        }
    }
}
