package Q6243;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class Solution {
    class TreeNode {
        int val;
        List<TreeNode> linked = new ArrayList<>();
        int depth;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int cityNum = roads.length+1;
        if(cityNum == 1) return 0;
        TreeNode[] treeNodes = new TreeNode[cityNum];
        for (int i = 0; i < treeNodes.length; i++) {
            treeNodes[i]=new TreeNode(i);
        }
        for (int i = 0; i < roads.length; i++) {
            int index1 = roads[i][0];
            int index2 = roads[i][1];
            treeNodes[index1].linked.add(treeNodes[index2]);
            treeNodes[index2].linked.add(treeNodes[index1]);
        }
        boolean[] visited = new boolean[treeNodes.length];
        dfs(treeNodes[0],0,visited);

        Arrays.sort(treeNodes, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.depth - o1.depth;
            }
        });

        int[] val2Index  =  new int[treeNodes.length];
        for (int i = 0; i < treeNodes.length; i++) {
            val2Index[treeNodes[i].val] = i;
        }

        long res = 0;
        boolean[] arrived = new boolean[treeNodes.length];
        for (int i = 0; i < treeNodes.length-1; i++) {  // 0 不用算
            if(arrived[treeNodes[i].val]) continue;
            int curSeats = 1;
            int curCarNum = 1;
            int curTreeNodeVal = treeNodes[i].val;
            while (curTreeNodeVal != 0){
                arrived[curTreeNodeVal] = true;
                for (int j = 0; j < treeNodes[curTreeNodeVal].linked.size(); j++) {
                    if(treeNodes[val2Index[curTreeNodeVal]].linked.get(j).val == 0){
                        res+= curCarNum;
                        curTreeNodeVal = 0;
                        break;
                    }else if(!arrived[treeNodes[val2Index[curTreeNodeVal]].linked.get(j).val]){
                        curTreeNodeVal = treeNodes[val2Index[curTreeNodeVal]].linked.get(j).val;
                        if(curSeats + 1 > seats){
                            res += curCarNum;
                            curCarNum ++;
                            curSeats = 1;
                        }else {
                            curSeats ++;
                            res += curCarNum;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(TreeNode root,int depth,boolean[] visited){
        root.depth = depth;
        visited[root.val] = true;
        for(TreeNode tn : root.linked){
            if(!visited[tn.val])  dfs(tn,depth+1,visited);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long res = s.minimumFuelCost(new int[][]{{0,1},{0,2},{1,3},{1,4}},5);
        System.out.println(res);
    }

}

