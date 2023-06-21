package Q1598;

class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(String s :logs){
            if(s.equals("../")){
                if(ans != 0){
                    ans--;
                }
            } else if (s.equals("./")) {
                continue;
            }else {
                ans++;
            }
        }
        return ans;
    }
}
