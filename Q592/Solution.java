package Q592;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String fractionAddition(String expression) {

        int i= 0;
        if(expression.charAt(0) != '-')
        {
            expression = "+" + expression;
        }
        String ans = "";
        for(int index=0;index<= expression.length();index++)
        {
            if(index == expression.length() || expression.charAt(index) == '+' || expression.charAt(index) == '-' )
            {
                if(index == 0)
                {
                    continue;
                }
                else
                {
                    if(ans == "")
                    {
                        ans += expression.substring(i,index);
                    }
                    else
                    {
                        ans = calcStringPlus(ans,expression.substring(i,index));
                    }
                }
                i = index;
            }
        }
        if(ans.charAt(0)=='+')
        {
            return ans.substring(1,ans.length());
        }
        else
        {
            return ans;
        }

    }

    public String calcStringPlus(String a, String b)
    {
        String[] fzafma = a.split("/");
        int fz1 = Integer.parseInt(fzafma[0].substring(1,fzafma[0].length()));
        int fm1 = Integer.parseInt(fzafma[1]);
        if(fzafma[0].charAt(0) == '-')
        {
            fz1 = -fz1;
        }

        String[] fzafmb = b.split("/");
        int fz2 = Integer.parseInt(fzafmb[0].substring(1,fzafmb[0].length()));
        int fm2 = Integer.parseInt(fzafmb[1]);
        if(fzafmb[0].charAt(0) == '-')
        {
            fz2 = -fz2;
        }

        int gcdRes = gcd(fm1,fm2);

        int fmRes = fm1*fm2/gcdRes;
        int fzRes = fz1*(fmRes/fm1) + fz2*(fmRes/fm2);

        int fzfmGcdRes = gcd(fmRes,fzRes);
        int ansFz = fzRes / fzfmGcdRes;
        int ansFm = fmRes / fzfmGcdRes;

        String res ="";
        if((ansFz >= 0))
        {
            res += "+";
        }

        res = res + ansFz + "/" + ansFm;
        return res;
    }
    public int gcd(int a, int b)
    {
        a= Math.abs(a);
        b= Math.abs(b);
        if(a<b)
        {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b>0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String n = s.fractionAddition("1/3-1/2");
        System.out.println(n);
    }
}
