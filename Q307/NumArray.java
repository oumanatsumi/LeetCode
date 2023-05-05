package Q307;

import java.util.Arrays;

/**
 * 使用数组实现线段树
 */
class SegmentTree<E> {

    private Node[] data;
    private int size;

    private Merger<E> merger;

    public SegmentTree(E[] source, Merger<E> merger) {
        this.merger = merger;
        this.size = source.length;
        this.data = new Node[size * 4];
        buildTree(0, source, 0, size - 1);
    }

    public E search(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft > size || queryRight < 0 || queryRight > size
                || queryLeft > queryRight) {
            throw new IllegalArgumentException("index is illegal");
        }
        return search(0, queryLeft, queryRight);
    }

    /**
     * 查询区间queryLeft-queryRight的值
     */
    private E search(int treeIndex, int queryLeft, int queryRight) {
        Node treeNode = data[treeIndex];
        int left = treeNode.left;
        int right = treeNode.right;
        if (left == queryLeft && right == queryRight) {
            return elementData(treeIndex);
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int middle = left + ((right - left) >> 1);
        if (queryLeft > middle) {
            return search(rightTreeIndex, queryLeft, queryRight);
        } else if (queryRight <= middle) {
            return search(leftTreeIndex, queryLeft, queryRight);
        }
        E leftEle = search(leftTreeIndex, queryLeft, middle);
        E rightEle = search(rightTreeIndex, middle + 1, queryRight);
        return merger.merge(leftEle, rightEle);
    }

    public void update(int index, E e) {
        update(0, index, e);
    }

    /**
     * 更新索引为index的值为e
     */
    private void update(int treeIndex, int index, E e) {
        Node treeNode = data[treeIndex];
        int left = treeNode.left;
        int right = treeNode.right;
        if (left == right) {
            treeNode.data = e;
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int middle = left + ((right - left) >> 1);
        if (index > middle) {
            update(rightTreeIndex, index, e);
        } else {
            update(leftTreeIndex, index, e);
        }
        treeNode.data = merger.merge(elementData(leftTreeIndex), elementData(rightTreeIndex));
    }

    private void buildTree(int treeIndex, E[] source, int left, int right) {
        if (left == right) {
            data[treeIndex] = new Node<>(source[left], left, right);
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int middle = left + ((right - left) >> 1);
        buildTree(leftTreeIndex, source, left, middle);
        buildTree(rightTreeIndex, source, middle + 1, right);
        E treeData = merger.merge(elementData(leftTreeIndex), elementData(rightTreeIndex));
        data[treeIndex] = new Node<>(treeData, left, right);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private E elementData(int index) {
        return (E) data[index].data;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private static class Node<E> {

        E data;
        int left;
        int right;

        Node(E data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public interface Merger<E> {

        E merge(E e1, E e2);
    }
}



class NumArray {
    public SegmentTree<Integer> tree;
    public NumArray(int[] nums) {
        int n = nums.length;
        Integer[] nums_ = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums_[i] = nums[i];
        }
        tree = new SegmentTree<>(nums_,Integer::sum);
    }

    public void update(int index, int val) {
        tree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return tree.search(left, right);
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */