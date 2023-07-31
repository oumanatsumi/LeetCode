package Q1_500.Q51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queen = new int[n];
        Set<Integer> col = new HashSet<>();
        Set<Integer> incline1 = new HashSet<>();
        Set<Integer> incline2 = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        backTrack(res, 0, queen, col, incline1, incline2);
        return res;
    }

    private void backTrack(List<List<String>> res,int index,int[] queen,Set<Integer> col,
                           Set<Integer> incline1, Set<Integer> incline2){
        if(index == queen.length){
            res.add(array2Board(queen));
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            if(!col.contains(i) && !incline1.contains(i) && !incline2.contains(i)){
                col.add(i);
                incline1.add(i);
                incline2.add(i);
                queen[index] = i;
                backTrack(res, index +1, queen, col, incline1, incline2);
                col.remove(i);
                incline1.remove(i);
                incline2.remove(i);
            }
        }
    }

    private List<String> array2Board(int[] queen){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queen.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queen.length; j++) {
                if(queen[i] == j) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
