package Q2458;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    int[] nodeHeight = new int[100001];
    TreeNode[] nodes = new TreeNode[100001];
    int[] res = new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        getDepth(root);
        dfs(root,-1,0);
        for (int i = 0; i < queries.length; i++) {
            ans[i] = res[queries[i]];
        }
        return ans;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        nodes[root.val] = root;
        int h = 1 + Math.max(getDepth(root.left),getDepth(root.right));
        nodeHeight[root.val] = h;
        return h;
    }
    
    private void dfs(TreeNode root,int depth,int restH){
        if(root == null){
            return;
        }
        depth++;
        res[root.val] = restH;
        dfs(root.left, depth, Math.max(restH, root.right==null? depth:depth+nodeHeight[root.right.val]));
        dfs(root.right, depth, Math.max(restH, root.left==null? depth:depth+nodeHeight[root.left.val]));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[5].left = nodes[8];
        nodes[5].right = nodes[9];
        nodes[8].left = nodes[2];
        nodes[8].right = nodes[1];
        nodes[2].left = nodes[4];
        nodes[2].right = nodes[6];
        nodes[9].left = nodes[3];
        nodes[9].right = nodes[7];
        s.treeQueries(nodes[5], new int[]{3,2,4,8});
    }

}
