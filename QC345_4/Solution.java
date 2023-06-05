package QC345_4;

import java.util.*;

public class Solution {
    class UnionFind{
        int[] parent;// parent[i]表示i这个元素指向的父亲节点
        int[] size;//size[i]表示以i为根节点的集合中元素个数
        int n;//节点的个数，初始化每一个节点都是一个单独的连通分量
        int setCount;//连通分量的数目
        public UnionFind(int n){
            this.size=new int[n];
            this.parent=new int[n];
            this.n=n;
            this.setCount=n;
            Arrays.fill(size,1);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int x){
            return parent[x]==x?x:find(parent[x]);
        }

        public boolean unit(int x,int y){
            x=find(x);
            y=find(y);
            if(x==y){
                return false;
            }
            if(size[x]<size[y]){
                int tem=x;
                x=y;
                y=tem;
            }

            parent[y]=x;
            size[x]+=size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int[] edgeCnt = new int[n];
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.unit(edges[i][0], edges[i][1]);
            edgeCnt[edges[i][0]]++;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = unionFind.find(i);
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<Integer>());
            }
            map.get(p).add(i);
        }
        int res = 0;
        for(int i : map.keySet()){
            int tmp = 0;
            for(int j: map.get(i)){
                tmp += edgeCnt[j];
            }
            int t = map.get(i).size();
            if(tmp == ( t*t-t) /2) res++;
        }
        return res;
    }

}
