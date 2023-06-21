package Q6231;

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;
        if(candidates == 1){
            int l = 0, r = n-1;
            for (int i = 0; i < k; i++) {
                if(costs[l]<= costs[r]){
                    res += costs[l];
                    l++;
                }else {
                    res += costs[r];
                    r--;
                }
            }
            return res;
        }

        int l = candidates-1;
        int r = n-candidates;

        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        if(l >= r){
            for (int i = 0; i < n/2; i++) {
                pqLeft.add(costs[i]);
            }
            for (int i =  n/2; i < n; i++) {
                pqRight.add(costs[i]);
            }
        }
        else {
            for (int i = 0; i <= l; i++) {
                pqLeft.add(costs[i]);
            }
            for (int i = r; i < n; i++) {
                pqRight.add(costs[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            if(pqLeft.isEmpty()){
                res += pqRight.poll();
                r--;
                if(l < r){
                    pqRight.add(costs[r]);
                }
            }
            else if(pqRight.isEmpty()){
                res += pqLeft.poll();
                l++;
                if(l < r) {
                    pqLeft.add(costs[l]);
                }
            }
            else if(pqLeft.peek() <= pqRight.peek()){
                res += pqLeft.poll();
                l++;
                if(l < r) {
                    pqLeft.add(costs[l]);
                }
            }
            else {
                res += pqRight.poll();
                r--;
                if(l < r){
                    pqRight.add(costs[r]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long res = s.totalCost(new int[]{18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75}
                ,13,23);
        System.out.println(res);
    }
}
