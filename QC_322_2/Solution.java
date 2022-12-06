package QC_322_2;

public class Solution {
    public long dividePlayers(int[] skill) {
        long totalSkill = 0;
        int n = skill.length;
        int[] map = new int[1002];
        for (int i = 0; i < n; i++) {
            totalSkill += skill[i];
            map[skill[i]] ++;
        }
        if( n!= 2 && totalSkill % (n/2) != 0) return -1;
        long each = totalSkill*2 / n;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if(map[(int) (each - skill[i])] <= 0 ) return -1;
            map[(int) (each - skill[i])]--;
            res += skill[i]*(each - skill[i]);
        }
        return res / 2 ;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.dividePlayers(new int[]{3,2,5,1,3,4});
    }

}
