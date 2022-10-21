package SPOffer38;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> set = new HashSet<>();
    int len ;
    public String[] permutation(String s) {
        len = s.length();
        dfs("",s,new int[len]);
        String[] res = set.toArray(new String[set.size()]);
        return res;
    }

    private void dfs(String cur , String s, int[] visited){
        if(cur.length() == len){
            set.add(cur);
            return;
        }
        for (int i = 0; i < len; i++) {
            if(visited[i] == 1){
                continue;
            }
            cur += s.charAt(i);
            visited[i] = 1;
            dfs(cur,s,visited);
            visited[i] = 0;
            cur = cur.substring(0,cur.length()-1);
        }
    }
}
