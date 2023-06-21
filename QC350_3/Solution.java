package QC350_3;

import java.util.*;


class Solution {

    /**
     * 方法一：多个哈希表+记忆化搜索
     */
//    Map<Integer, List<Integer>> map = new HashMap<>();
//    Map<Integer, Integer> indexMap = new HashMap<>();
//    Map<String, Integer> dpMap = new HashMap<>();
//    int n = 0;
//    int MOD = 1000000007;
//
//
//    public int specialPerm(int[] nums) {
//        n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int cur = nums[i];
//            map.put(cur, new ArrayList<>());
//            indexMap.put(cur, i);
//            for (int j = 0; j < n; j++) {
//                if(j != i && (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0)){
//                    map.get(cur).add(nums[j]);
//                }
//            }
//        }
//        return dfs(0, -1, new boolean[n], 0);
//    }
//
//    public int dfs(int index, int lastNum, boolean[] visited, int stat){
//        if(index == n) {
//            return 1;
//        }
//        String tmp = lastNum + "#" + stat;
//        if(dpMap.containsKey(tmp)) return dpMap.get(tmp);
//        int sum = 0;
//        if(lastNum == -1){
//            for(int i : map.keySet()){
//                visited[indexMap.get(i)] = true;
//                sum = (sum + dfs(index + 1, i, visited, stat + (1 << indexMap.get(i)))) % MOD;
//                visited[indexMap.get(i)] = false;
//            }
//            return sum;
//        }
//        for(int i: map.get(lastNum)){
//            if(!visited[indexMap.get(i)]){
//                visited[indexMap.get(i)] = true;
//                sum = (sum + dfs(index + 1, i, visited, stat + (1 << indexMap.get(i)))) % MOD;
//                visited[indexMap.get(i)] = false;
//            }
//        }
//        dpMap.put(tmp, sum);
//        return sum;
//    }

    /**
     * 方法二：一个哈希表+记忆化搜索
     */

//    Map<String, Integer> dpMap = new HashMap<>();
//    int MOD = 1000000007;
//
//    public int specialPerm(int[] nums) {
//        return dfs(0, -1, nums, new boolean[nums.length], 0);
//    }
//
//    public int dfs(int index, int lastNum, int[] nums, boolean[] visited, int stat){
//        if(index == nums.length) {
//            return 1;
//        }
//        String tmp = lastNum + "#" + stat;
//        if(dpMap.containsKey(tmp)) return dpMap.get(tmp);
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(lastNum == -1){
//                visited[i] = true;
//                sum = (sum + dfs(index + 1, nums[i], nums, visited, stat + (1 << i))) % MOD;
//                visited[i] = false;
//            }
//            else if(!visited[i] && (nums[i] % lastNum == 0 || lastNum % nums[i] == 0)){
//                visited[i] = true;
//                sum = (sum + dfs(index + 1, nums[i], nums, visited, stat + (1 << i))) % MOD;
//                visited[i] = false;
//            }
//        }
//        dpMap.put(tmp, sum);
//        return sum;
//    }

    /**
     * 方法三：dp
     */

    int MOD = 1000000007;

    public int specialPerm(int[] nums) {
        int n = nums.length, m = 1 << n;
        // dp[i][j]，其中i表示已经选了几个数，压缩成一个14位的二进制数，j表示上一个数的下标
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int k = 0; k < n; k++) {
                // 需要k在集合i里面（自底向上逆推）,也可以写成(i >> k & 1) == 0
                if((i & 1 << k) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if(nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0){
                        // 这里的异或和减法是一个意思。就是要在i这个二进制数中除去k这一位，达到递推的目的
                        dp[i][j] = (dp[i][j] + dp[i ^ (1 << k)][k]) % MOD ;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dp[(m-1) ^ (1 << i)][i] % MOD ) % MOD;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.specialPerm(new int[]{2, 3, 6}));
    }
}
