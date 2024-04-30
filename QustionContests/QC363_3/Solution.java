package QustionContests.QC363_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long totalStockAfford = 0;
        for (int i = 0; i < n; i++) {
            totalStockAfford += (long) stock.get(i) * cost.get(i);
        }
        long maxComp = 0;
        for (int i = 0; i < k; i++) {
            int curBudget = budget;
            List<Integer> curStock = new ArrayList<>();
            for (int s : stock) {
                curStock.add(s);
            }
            List<Integer> curComp = composition.get(i);

            List<Integer> stockAffordTime = new ArrayList<>();
            List<Integer> stockAffordLast = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stockAffordTime.add(stock.get(j) / curComp.get(j));
            }
            for (int j = 0; j < n; j++) {
                stockAffordLast.add(stock.get(j) % curComp.get(j));
            }
            int eachCost = 0;
            for (int j = 0; j < n; j++) {
                eachCost += cost.get(j) * curComp.get(j);
            }
            long l = Math.max(0,budget / eachCost - 1);
            long r = (budget + totalStockAfford) / eachCost + 1;
            long mid;
            while (l <= r) {
                mid = (l + r) >>> 1;
                curBudget = budget;
                for (int j = 0; j < n; j++) {
                    if (stockAffordTime.get(j) < mid) {
                        curBudget -= (mid - stockAffordTime.get(j)) * cost.get(j) * curComp.get(j)
                                - (long) stockAffordLast.get(j) * cost.get(j);
                    }
                    if (curBudget < 0) break;
                }
                if (curBudget < 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            maxComp = Math.max(maxComp, r);
        }
        return (int) maxComp;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> composition = new ArrayList<>();
        composition.add(Arrays.asList(2, 1));
        composition.add(Arrays.asList(1, 2));
        composition.add(Arrays.asList(1, 1));
        List<Integer> stock = new ArrayList<Integer>() {{
            add(1);
            add(1);
        }};
        List<Integer> cost = new ArrayList<Integer>() {{
            add(5);
            add(5);
        }};
        System.out.println(s.maxNumberOfAlloys(2, 3, 10, composition, stock, cost));
    }
}