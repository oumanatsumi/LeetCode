package Q2501_3000.Q2762;

import java.util.TreeMap;

class Solution {

     // 方法1 ：线段树 + 滑窗
//     public long continuousSubarrays(int[] nums) {
//          int n = nums.length;
//          long res = 0;
//          MySegmentTree tree = new MySegmentTree(nums);
//
//          int max11 = tree.queryMinValue(0,0,5);
//          int l = 0;
//          for (int r = 0; r < n; r++) {
//               while (l < r && tree.queryMaxValue(0,l,r) - tree.queryMinValue(0,l,r) > 2){
//                    int max = tree.queryMaxValue(0,l,r);
//                    int min = tree.queryMinValue(0,l,r);
//                    l++;
//               }
//               res += r - l + 1;
//          }
//          return res;
//     }

     // 方法2：有序哈希表 + 滑窗
     public long continuousSubarrays(int[] nums) {
          int n = nums.length;
          long res = 0;

          TreeMap<Integer, Integer> treeMap = new TreeMap<>();
          int l = 0;
          for (int r = 0; r < n; r++) {
               treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
               while (l < r && treeMap.lastEntry().getKey() - treeMap.firstEntry().getKey() > 2){
                    if(treeMap.get(nums[l]) == 1){
                         treeMap.remove(nums[l]);
                    }else {
                         treeMap.put(nums[l], treeMap.get(nums[l])-1);
                    }
                    l++;
               }
               res += r - l + 1;
          }
          return res;
     }

     public static void main(String[] args) {
          Solution s = new Solution();
          System.out.println(s.continuousSubarrays(new int[]{65,66,67,66,66,65,64,65,65,64}));
     }
}
