package Q6188;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    class stu{
        String name;
        int height;

        stu(String n , int h){
            this.name = n;
            this.height = h;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        stu[] stus = new stu[n];
        for (int i = 0; i < n; i++) {
            stus[i]  = new stu(names[i],heights[i]);
        }

        Arrays.sort(stus, new Comparator<stu>() {
            @Override
            public int compare(stu o1, stu o2) {
                return o2.height- o1.height;
            }
        });

        for (int i = 0; i < n; i++) {
            names[i] = stus[i].name;
        }
        return names;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] res = s.sortPeople(new String[]{"Alice","Bob","Bob"}, new int[]{155,185,150});
        for(String S: res){
            System.out.println(S);
        }
    }

}
