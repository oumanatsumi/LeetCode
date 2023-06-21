package Q1_500.Q307;

class MySegmentTree {
    private class Node{
        int val;
        int left;
        int right;

        public Node(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int size;
    private Node[] nodes;
    private int[] nums;

    public MySegmentTree(int[] nums){
        this.size = nums.length;
        this.nodes = new Node[size * 4];
        this.nums = nums;
        buildTree(0, 0, size-1);
    }

    public void buildTree(int curIndex, int left , int right){
        if(left == right){
            nodes[curIndex] = new Node(nums[left], left, right);
            return;
        }
        int leftNodeIndex = curIndex * 2 + 1;
        int rightNodeIndex = curIndex * 2 + 2;
        int mid = (left + right) >>> 1;
        buildTree(leftNodeIndex, left, mid);
        buildTree(rightNodeIndex, mid+1, right);
        int curNodeVal = nodes[leftNodeIndex].val + nodes[rightNodeIndex].val;
        nodes[curIndex] = new Node(curNodeVal, left, right);
    }

    public void updateSingleNode(int nodeIndex, int index, int newVal){
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
        if(index > mid){
            updateSingleNode(rightNodeIndex, index , newVal);
        }else {
            updateSingleNode(leftNodeIndex,index,newVal );
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
        int mid = (left + right) >>> 1;
        int leftSum = 0, rightSum = 0;
        if(queryLeft <= mid){
            leftSum = sumRange(nodeIndex * 2 + 1, queryLeft, mid);
        }
        if(queryRight > mid){
            rightSum = sumRange(nodeIndex * 2 + 2, mid+1, queryRight);
        }
        return leftSum + rightSum;
    }

}
