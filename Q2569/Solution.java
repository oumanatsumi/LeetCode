package Q2569;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

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
        public Node[] nodes;
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

        public void updateRange(int nodeIndex, int rangeLeft, int rangeRight){
            Node curNode = nodes[nodeIndex];
            int left = curNode.left;
            int right = curNode.right;

            int leftNodeIndex = nodeIndex * 2 + 1;
            int rightNodeIndex = nodeIndex * 2 + 2;

            if(rangeLeft == left && rangeRight == right){
                curNode.val = rangeRight - rangeLeft + 1 - curNode.val;
                if(left != right) curNode.lazy = 1 - curNode.lazy;
                return;
            }

            if(curNode.lazy != 0 && nodes[leftNodeIndex]!=null){
                if(nodes[leftNodeIndex].lazy == 0){
                    nodes[leftNodeIndex].lazy = 1;
                    nodes[leftNodeIndex].val = nodes[leftNodeIndex].right - nodes[leftNodeIndex].left + 1 - nodes[leftNodeIndex].val;
                }else {
                    nodes[leftNodeIndex].lazy = 0;
                }
                if(nodes[rightNodeIndex].lazy == 0){
                    nodes[rightNodeIndex].lazy = 1;
                    nodes[rightNodeIndex].val = nodes[rightNodeIndex].right - nodes[rightNodeIndex].left + 1 - nodes[rightNodeIndex].val;
                }else {
                    nodes[rightNodeIndex].lazy = 0;
                }
                curNode.lazy = 0;
            }



            int mid = (left + right) >>> 1;

            if(rangeRight <= mid){
                updateRange(leftNodeIndex, rangeLeft, rangeRight);
            } else if(rangeLeft > mid) {
                updateRange(rightNodeIndex, rangeLeft, rangeRight);
            } else {
                updateRange(leftNodeIndex, rangeLeft, mid);
                updateRange(rightNodeIndex, mid+ 1, rangeRight);
            }
            curNode.val = nodes[leftNodeIndex].val + nodes[rightNodeIndex].val;
        }


        public void clearAllLazyTag(int nodeIndex, int queryLeft, int queryRight){
            Node curNode = nodes[nodeIndex];
            int left = curNode.left;
            int right = curNode.right;

            int leftNodeIndex = nodeIndex * 2 + 1;
            int rightNodeIndex = nodeIndex * 2 + 2;

            if(queryLeft == queryRight){
                curNode.lazy = 0;
                return ;
            }

            if(leftNodeIndex < nodes.length && curNode.lazy != 0 && nodes[leftNodeIndex]!=null){
                if(nodes[leftNodeIndex].lazy == 0){
                    nodes[leftNodeIndex].lazy = 1;
                    nodes[leftNodeIndex].val = nodes[leftNodeIndex].right - nodes[leftNodeIndex].left + 1 - nodes[leftNodeIndex].val;
                }else {
                    nodes[leftNodeIndex].lazy = 0;
                }
                if(nodes[rightNodeIndex].lazy == 0){
                    nodes[rightNodeIndex].lazy = 1;
                    nodes[rightNodeIndex].val = nodes[rightNodeIndex].right - nodes[rightNodeIndex].left + 1 - nodes[rightNodeIndex].val;
                }else {
                    nodes[rightNodeIndex].lazy = 0;
                }
                curNode.lazy = 0;
            }



            int mid = (left + right) >>> 1;
            if(queryLeft <= mid){
                clearAllLazyTag(leftNodeIndex, queryLeft, mid);
            }
            if(queryRight > mid){
                clearAllLazyTag(rightNodeIndex, mid+1, queryRight);
            }
        }

    }


    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        MySegmentTreePlus tree = new MySegmentTreePlus(nums1);
        int n = nums1.length;
        List<Long> ansList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if(queries[i][0] == 1){
                tree.updateRange(0,queries[i][1],queries[i][2]);
            }else if(queries[i][0] == 2){
                tree.clearAllLazyTag(0,0, n-1);
                for (int j = 0; j < 4*n; j++) {
                    if(tree.nodes[j] == null || tree.nodes[j].left != tree.nodes[j].right) continue;
                    int curNumIndex = tree.nodes[j].left;
                    nums2[curNumIndex] += queries[i][1] * tree.nodes[j].val;
                }
            }else {
                Long tmp = 0L;
                for (int j = 0; j < n; j++) {
                    tmp += nums2[j];
                }
                ansList.add(tmp);
            }
        }
        long[] ans = new long[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        long[] res = s.handleQuery(new int[]{1,1,1,1,0,1,1,0,0,0},
                new int[]{33,13,13,5,34,7,47,2,14,6},
                new int[][]{{2,14,0},{1,8,8},{3,0,0},{1,3,6},{1,3,9},{1,8,8},{3,0,0},{1,8,9},
                        {3,0,0},{2,28,0},{3,0,0},{2,22,0},{2,21,0},{3,0,0},{3,0,0},{1,5,7},{1,0,3},{2,7,0},{3,0,0},{3,0,0}});

        for(long r : res){
            System.out.println(r);
        }
    }
}
