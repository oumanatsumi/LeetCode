package Q6242;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


class Solution {
    List<Integer> order = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int q:queries){
            res.add(Search(order,q));
        }
        return res;
    }

    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        order.add(root.val);
        traverse(root.right);
    }


    private List<Integer> Search(List<Integer> arr,int key){
        int low = 0;
        int high = arr.size() - 1;
        int middle = 0;			//定义middle

        List<Integer> res = new ArrayList<>();

        while(low <= high){
            middle = (low + high) / 2;
            if(arr.get(middle) > key){
                high = middle - 1;
            }else if(arr.get(middle) < key){
                low = middle + 1;
            }else{
                res.add(arr.get(middle));
                res.add(arr.get(middle));
                return res;
            }
        }
        if(high < 0) {
            res.add(-1);
            res.add(arr.get(low));
        }else if(low > arr.size()-1){
            res.add(arr.get(high));
            res.add(-1);
        }else {
            res.add(arr.get(high));
            res.add(arr.get(low));
        }
        return res;
    }
}
