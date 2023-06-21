package SPOffer.SPOffer19;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(j == 0){
                    f[i][j] = i==0;
                }else
                {
                    if(p.charAt(j-1) != '*'){
                        if(i>0 && (p.charAt(j-1) == '.' || p.charAt(j-1)==s.charAt(i-1))){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else
                    {
                        // 不管这个*的匹配，即0个字符
                        if(j >= 2){
                            f[i][j] |= f[i][j-2];
                        }
                        // 管
                        if(j>= 2 && i >0 &&(p.charAt(j-2) == '.' || p.charAt(j-2)==s.charAt(i-1))){
                            f[i][j] |= f[i-1][j];
                        }
                        // 之所以用|= 是因为上述两个条件满足一个就行
                    }
                }
            }
        }
        return f[m][n];
    }
}
