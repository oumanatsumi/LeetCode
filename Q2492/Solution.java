package Q2492;

import java.util.Arrays;
import java.util.Comparator;

class UnionFind {
    private int[] parent;
    private int[] weight;
    private int size;

    public UnionFind(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);

        //如果已经属于同一个集合了，就不用再合并了。
        if (firstRoot == secondRoot) {
            return;
        }
        if (weight[firstRoot] > weight[secondRoot]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {//weight[firstRoot] <= weight[secondRoot]
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }
    }

}


public class Solution {
    public int minScore(int n, int[][] roads) {
        UnionFind unionFind = new UnionFind(n+10);
        Arrays.sort(roads, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int[] road: roads) {
            unionFind.unionElements(road[0],road[1]);
        }
        int small = 0, big = 0;
        for (int[] road: roads) {
            small = Math.min(road[0],road[1]);
            big = Math.max(road[0],road[1]);
            if(unionFind.isConnected(1, small) && unionFind.isConnected(big, n)){
                return road[2];
            }
        }
        return -1;
    }
}
