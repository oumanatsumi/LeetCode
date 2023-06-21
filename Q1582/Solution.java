package Q1582;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //直接开造
    public int numSpecial(int[][] mat) {
        int rows = mat.length,cols = mat[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int temp = -1;
            int cnt = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    if (cnt == 0) {
                        temp = j;
                    }
                    cnt++;
                }
            }
            if (cnt == 1) {
                int sum = 0;
                for (int j = 0; j < rows; j++) {
                    sum += mat[j][temp];
                }
                if (sum == 1) {
                    res++;
                }
            }
        }
        return res;
    }
    //两次遍历
    public int numSpecial_1(int[][] mat) {
        int rows = mat.length,cols = mat[0].length;
        //这个map用来记录同一列中是否有重复， 遍历每一行，若该行只有一个1，那么插入该点的<列序号，行序号>
        Map<Integer,Integer> map = new HashMap<>();
        //第一次遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 1){
                    map.put(j, map.getOrDefault(j,0)+1);
                }
            }
        }
        //第二次遍历
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int temp = -1;
            int cnt = 0;
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j] == 1){
                    if(cnt == 0){
                        temp = j;
                    }
                    cnt++;
                }
            }
            if(cnt == 1 && map.get(temp) == 1){
                res ++;
            }
        }

        return res;
    }
}
