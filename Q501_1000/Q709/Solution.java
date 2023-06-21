package Q501_1000.Q709;

class Solution {
    public String toLowerCase(String s) {
        String res ="";
        for(char c :s.toCharArray())
        {
            if(c>='A' && c<='Z')
            {
                res = res + (char)(c+32);
            }
            else
            {
                res = res +c;
            }
        }
        return res;
    }
}
