package LeetCode.Q559;

public class Solution {
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
