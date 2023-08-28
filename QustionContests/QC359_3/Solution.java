package QustionContests.QC359_3;

import java.util.*;

class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1)-o2.get(1);
            }
        });
        int len = offers.size();
        int[] prev = new int[len+1];
        prev[0] = 0;
        // 此处还能优化，辅助数组记录左端点
//        for (int i = 1; i <= len; i++) {
//            prev[i] = 0;
//            for (int j = i-1; j > 0 ; j--) {
//                if(offers.get(i-1).get(0) > offers.get(j-1).get(1)){
//                    prev[i] = j;
//                    break;
//                }
//            }
//        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(-1,0);
        for (int i = 1; i <= len; i++) {
            prev[i] = treeMap.get(treeMap.floorKey(offers.get(i-1).get(0)-1));
            treeMap.put(offers.get(i-1).get(1),i);
        }
        int[] dp = new int[len+1];
        dp[0] = 0;
        for (int i = 1; i <= len ; i++) {
            dp[i] = Math.max(dp[i-1], dp[prev[i]]+offers.get(i-1).get(2));
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> offers = new ArrayList<>();
        List<Integer> o1 = new ArrayList<>();
        List<Integer> o2 = new ArrayList<>();
        List<Integer> o3 = new ArrayList<>();
        List<Integer> o4 = new ArrayList<>();
        o1.add(0);
        o1.add(0);
        o1.add(5);
        o2.add(3);
        o2.add(3);
        o2.add(1);
        o3.add(1);
        o3.add(2);
        o3.add(5);
        o4.add(0);
        o4.add(0);
        o4.add(7);
        offers.add(o1);
        offers.add(o2);
        offers.add(o3);
        offers.add(o4);
        int res = s.maximizeTheProfit(4, offers);
        System.out.println(res);
    }
}
