package Q2501_3000.Q2762;

class MySegmentTree {
    private class Node{
        int maxVal;
        int minVal;
        int left;
        int right;

        public Node(int maxVal, int minVal, int left, int right) {
            this.maxVal = maxVal;
            this.minVal = minVal;
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
            nodes[curIndex] = new Node(nums[left], nums[left], left, right);
            return;
        }
        int leftNodeIndex = curIndex * 2 + 1;
        int rightNodeIndex = curIndex * 2 + 2;
        int mid = (left + right) >>> 1;
        buildTree(leftNodeIndex, left, mid);
        buildTree(rightNodeIndex, mid+1, right);
        int maxNodeVal = Math.max(nodes[leftNodeIndex].maxVal , nodes[rightNodeIndex].maxVal);
        int minNodeVal = Math.min(nodes[leftNodeIndex].minVal , nodes[rightNodeIndex].minVal);
        nodes[curIndex] = new Node(maxNodeVal, minNodeVal, left, right);
    }

    public void updateSingleNode(int nodeIndex, int index, int newVal){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;
        if(left == right){
            curNode.minVal = newVal;
            curNode.maxVal = newVal;
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
        curNode.maxVal = Math.max(nodes[leftNodeIndex].maxVal ,nodes[rightNodeIndex].maxVal) ;
        curNode.minVal = Math.min(nodes[leftNodeIndex].minVal ,nodes[rightNodeIndex].minVal) ;
    }

    public int queryMinValue(int nodeIndex, int queryLeft, int queryRight){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;
        if(queryLeft <= left && queryRight >= right){
            return curNode.minVal;
        }
        int mid = (left + right) >>> 1;
        int minValue = Integer.MAX_VALUE;
        if(queryLeft <= mid){
            minValue = Math.min(minValue, queryMinValue(nodeIndex * 2 + 1, queryLeft, queryRight));
        }
        if(queryRight > mid){
            minValue = Math.min(minValue, queryMinValue(nodeIndex * 2 + 2, queryLeft, queryRight));
        }
        return minValue;
    }

    public int queryMaxValue(int nodeIndex, int queryLeft, int queryRight){
        Node curNode = nodes[nodeIndex];
        int left = curNode.left;
        int right = curNode.right;
        if(queryLeft <= left && queryRight >= right){
            return curNode.maxVal;
        }
        int mid = (left + right) >>> 1;
        int maxValue = Integer.MIN_VALUE;
        if(queryLeft <= mid){
            maxValue = Math.max(maxValue, queryMaxValue(nodeIndex * 2 + 1, queryLeft, queryRight));
        }
        if(queryRight > mid){
            maxValue = Math.max(maxValue, queryMaxValue(nodeIndex * 2 + 2, queryLeft, queryRight));
        }
        return maxValue;
    }


}
