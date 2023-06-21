package QustionContests.QC332_3;

class Solution {
//    public int[][] substringXorQueries(String s, int[][] queries) {
//        int[][] ans = new int[queries.length][2];
//        boolean flag;
//        int tar;
//        for (int i = 0; i < queries.length; i++) {
//            tar = queries[i][0] ^ queries[i][1];
//            String str = Integer.toBinaryString(tar);
//            flag = false;
//            int subLen = str.length();
//            for (int j = 0; j <= s.length()-subLen; j++) {
//                if(s.substring(j,j+subLen).equals(str)){
//                    ans[i][0] = j;
//                    ans[i][1] = j+ subLen-1;
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag){
//                ans[i][0] = -1;
//                ans[i][1] = -1;
//            }
//        }
//        return ans;
//    }

//    public int[][] substringXorQueries(String s, int[][] queries) {
//        int n = queries.length;
//        int[][] ans = new int[n][2];
//        int[] targets = new int[n];
//        for (int i = 0; i < n; i++) {
//            targets[i] = queries[i][0] ^ queries[i][1];
//        }
//        List<Integer>[] bitCntMap = new List[31];
//        for (int i = 0; i < 31; i++) {
//            bitCntMap[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < n; i++) {
//            bitCntMap[32-Integer.numberOfLeadingZeros(targets[i])].add(targets[i]);
//        }
//
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < 31; i++) {
//            if(bitCntMap[i].size() == 0) continue;
//            for (int j = 0; j <= s.length()-i; j++) {
//                int tmp = -1;
//                if(i == 0 ){
//                    if(j!= s.length()-i && s.charAt(j) == '0') tmp = 0;
//                }else {
//                    tmp = Integer.parseInt(s.substring(j,j+i),2);
//                }
//                int index = bitCntMap[i].indexOf(tmp);
//                if(index != -1 && !map.containsKey(bitCntMap[i].get(index))){
//                    map.put(bitCntMap[i].get(index),j);
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if(map.containsKey(targets[i])){
//                ans[i][0] = map.get(targets[i]);
//                ans[i][1] = ans[i][0] + 32-Integer.numberOfLeadingZeros(targets[i]);
//                if(targets[i]!=0) ans[i][1] --;
//            }else {
//                ans[i][0] = -1;
//                ans[i][1] = -1;
//            }
//        }
//
//       return ans;
//    }

//    public int[][] substringXorQueries(String s, int[][] queries){
//        s
//    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(Integer.bitCount(0));
//        s.substringXorQueries("111010110", new int[][]{{3,3},{9,9}});
//    }
}
