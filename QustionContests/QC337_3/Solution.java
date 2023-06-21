package QustionContests.QC337_3;

import java.util.*;

class Solution {
//    public int beautifulSubsets(int[] nums, int k) {
//        int n = nums.length;
//        if(n == 1) return 1;
//        int ans = (1 << n)-1 ;
//
//        Map<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//        }
//
//        int lastNum = 0, lastCnt = 0;
//        for(int i : map.keySet()){
//            if(lastNum == 0) {
//                lastNum = i;
//                lastCnt = map.get(i);
//                continue;
//            }
//            if(i - lastNum == k){
//                ans -= lastCnt * map.get(i) *(1 << (n - 2));
//            }
//            lastNum = i;
//            lastCnt = map.get(i);
//        }
//
//        return ans;


    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0;i<nums.length;i++){
            int size = result.size();
            for (int j = 0;j<size;j++){
                List<Integer> clone = new ArrayList<>(result.get(j));
                if(clone.isEmpty() || !clone.contains(nums[i]- k)) {
                    clone.add(nums[i]);
                    result.add(clone);
                }
            }
        }
        return result.size()-1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.beautifulSubsets(new int[]{10,4,5,7,2,1}, 3));
    }
}
