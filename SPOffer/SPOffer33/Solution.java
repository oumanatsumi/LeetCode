package SPOffer.SPOffer33;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    private boolean verify(int[] postorder, int left, int right){
        if(left >= right) return true;
        int mid = right;
        int rootVal = postorder[right];
        for (int i = left; i < right; i++) {
            if(postorder[i]>rootVal){
                mid = i;
                break;
            }
        }
        for(int i= mid +1;i<right;i++){
            if(postorder[i]<rootVal) return false;
        }
        return verify(postorder,left,mid-1) && verify(postorder,mid,right-1);
    }
//    TreeNode root;
//
//    public boolean verifyPostorder(int[] postorder) {
//        for(int i: postorder){
//            buildBST(i);
//        }
//        List<Integer> res = postTraverse(root,new ArrayList<>());
//        for (int i = 0; i < postorder.length; i++) {
//            if(postorder[i] != res.get(i)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void buildBST(int _val){
//        if(this.root == null) {
//            this.root = new TreeNode(_val);
//            return;
//        }
//        TreeNode parent;
//        TreeNode cur = this.root;
//        while (true){
//            parent = cur;
//            if(_val < cur.val){
//                cur = cur.left;
//                if(cur == null){
//                    parent.left = new TreeNode(_val);
//                    return;
//                }
//            }
//            else {
//                cur = cur.right;
//                if(cur == null){
//                    parent.right = new TreeNode(_val);
//                    return;
//                }
//            }
//        }
//    }
//
//    private List<Integer> postTraverse(TreeNode root,List<Integer> res){
//        if(root == null) return res;
//        postTraverse(root.left,res);
//        res.add(root.val);
//        postTraverse(root.right,res);
//
//        return res;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }
}
