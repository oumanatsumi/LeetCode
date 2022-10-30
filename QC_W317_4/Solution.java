package QC_W317_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    int[] nodeMaxDepth= new int[100001];
    TreeNode[] nodes = new TreeNode[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        getDepth(root,new ArrayList<>(),0);
        for (int i = 0; i < queries.length; i++) {
            List<Integer> denies = new ArrayList<>();
            dfs(nodes[queries[i]],denies);
            for (int j = 0; j < nodeMaxDepth.length; j++) {
                if(denies.contains(j)) continue;
                ans[i] = Math.max(ans[i],nodeMaxDepth[j]);
            }
        }
        return ans;
    }

    private void getDepth(TreeNode root, List<Integer> list, int curDepth){
        if(root == null){
            for(int i :list){
                nodeMaxDepth[i] = Math.max(nodeMaxDepth[i],curDepth-1);
            }
            return;
        }
        nodes[root.val] = root;
        list.add(root.val);
        getDepth(root.left,list, curDepth+1);
        getDepth(root.right,list, curDepth+1);
        list.remove(list.size()-1);
    }
    
    private void dfs(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
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
        s.treeQueries(nodes[5], new int[]{8});
    }

}
