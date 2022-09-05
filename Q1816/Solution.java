package Q1816;

public class Solution {

    public String truncateSentence(String s, int k) {
        String[] ss = s.split(" ");
        String res = ss[0];
        for(int i=1;i<k;i++)
        {
            res = res+" "+ss[i];
        }
        return res;
    }

}
