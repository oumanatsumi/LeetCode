package Q1_500.Q307;

class MySegmentTreePlus {
    private class Node{
        int val;
        int left;
        int right;
        int lazy;

        public Node(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.lazy = 0;
        }
    }

    private int size;
    private Node[] nodes;
    private int[] nums;

    public MySegmentTreePlus(int[] nums){
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

    public void updateRange(int nodeIndex, int rangeLeft, int rangeRight, int addVal){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;

        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;

        if(curNode.lazy != 0 && nodes[leftNodeIndex]!=null){
            nodes[leftNodeIndex].lazy += curNode.lazy;
            nodes[leftNodeIndex].val += nodes[leftNodeIndex].lazy * (nodes[leftNodeIndex].right - nodes[leftNodeIndex].left + 1);
            nodes[rightNodeIndex].lazy += curNode.lazy;
            nodes[rightNodeIndex].val += nodes[rightNodeIndex].lazy * (nodes[rightNodeIndex].right - nodes[rightNodeIndex].left + 1);
            curNode.lazy = 0;
        }

        if(rangeLeft == left && rangeRight == right){
            curNode.val += addVal * (rangeRight - rangeLeft + 1);
            curNode.lazy += addVal;
            return;
        }

        int mid = (left + right) >>> 1;

        if(rangeRight <= mid){
            updateRange(leftNodeIndex, rangeLeft, rangeRight , addVal);
        } else if(rangeLeft > mid) {
            updateRange(rightNodeIndex, rangeLeft, rangeRight , addVal);
        } else {
            updateRange(leftNodeIndex, rangeLeft, mid , addVal);
            updateRange(rightNodeIndex, mid+ 1, rangeRight , addVal);
        }
        curNode.val = nodes[leftNodeIndex].val + nodes[rightNodeIndex].val;
    }


    public int sumRange(int nodeIndex, int queryLeft, int queryRight){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;

        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;

        if(curNode.lazy != 0 && nodes[leftNodeIndex]!=null){
            nodes[leftNodeIndex].lazy += curNode.lazy;
            nodes[leftNodeIndex].val = (nodes[leftNodeIndex].right - nodes[leftNodeIndex].left + 1) * nodes[leftNodeIndex].lazy;
            nodes[rightNodeIndex].lazy += curNode.lazy;
            nodes[rightNodeIndex].val = (nodes[rightNodeIndex].right - nodes[rightNodeIndex].left + 1) * nodes[rightNodeIndex].lazy;
            curNode.lazy = 0;
        }

        if(queryLeft == left && queryRight == right){
            return curNode.val;
        }

        int mid = (left + right) >>> 1;
        int leftSum = 0, rightSum = 0;
        if(queryLeft <= mid){
            leftSum = sumRange(leftNodeIndex, queryLeft, mid);
        }
        if(queryRight > mid){
            rightSum = sumRange(rightNodeIndex, mid+1, queryRight);
        }
        return leftSum + rightSum;
    }

}
