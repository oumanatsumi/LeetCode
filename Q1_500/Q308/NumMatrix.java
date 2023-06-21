package Q1_500.Q308;

class MySegmentTree{
    class Node{
        int val;
        int left;
        int right;

        public Node(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int[] nums;
    int size;
    Node[] nodes;

    public MySegmentTree(int[] nums){
        this.nums = nums;
        this.size = nums.length;
        this.nodes = new Node[4*size];
        buildTree(0,nums,0,size-1);
    }

    public void buildTree(int nodeIndex, int[] nums, int left, int right){
        if(left == right){
            nodes[nodeIndex] = new Node(nums[left], left, right);
            return;
        }
        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;
        int mid = (left + right) >>> 1;
        buildTree(leftNodeIndex, nums, left, mid);
        buildTree(rightNodeIndex, nums, mid+1, right);
        nodes[nodeIndex] = new Node(nodes[leftNodeIndex].val + nodes[rightNodeIndex].val, left, right);
    }

    public void updateVal(int nodeIndex, int index, int newVal){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;
        if(left == right){
            curNode.val = newVal;
            return;
        }
        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;
        int mid = (left + right) >>> 1;
        if(mid >= index){
            updateVal(leftNodeIndex, index, newVal);
        }else {
            updateVal(rightNodeIndex, index, newVal);
        }
        curNode.val = nodes[leftNodeIndex].val + nodes[rightNodeIndex].val;
    }

    public int sumRange(int nodeIndex, int queryLeft, int queryRight){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;
        if(queryLeft == left && queryRight == right){
            return curNode.val;
        }
        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;
        int mid = (left + right) >>> 1;
        int leftSum = 0, rightSum = 0;
        if(queryLeft > mid){
            return sumRange(rightNodeIndex, queryLeft, queryRight);
        }else if(queryRight <= mid){
            return sumRange(leftNodeIndex, queryLeft, queryRight);
        }
        leftSum = sumRange(leftNodeIndex, queryLeft, mid);
        rightSum = sumRange(rightNodeIndex, mid+1, queryRight);
        return leftSum + rightSum;
    }
}

class NumMatrix {

    int[] nums;
    MySegmentTree tree;
    int r,l;
    public NumMatrix(int[][] matrix) {
        r = matrix.length;
        l = matrix[0].length;
        nums = new int[r*l];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                nums[i * l + j] = matrix[i][j];
            }
        }
        tree = new MySegmentTree(nums);
    }

    public void update(int row, int col, int val) {
        tree.updateVal(0, l*row+col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += tree.sumRange(0, i*l+col1, i*l + col2);
        }
        return sum;
    }


    public static void main(String[] args) {
        NumMatrix s = new NumMatrix(new int[][] {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        int res1 = s.sumRegion(2,1,4,3);
        s.update(3,2,2);
        System.out.println(res1);
        int res2 = s.sumRegion(2,1,4,3);
        System.out.println(res2);
    }
}
