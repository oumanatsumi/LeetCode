package Q166;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;

        boolean positive;
        if(numeratorLong*denominatorLong<0)
        {
            positive =false;
        }
        else
        {
            positive = true;
        }
        numeratorLong=Math.abs(numeratorLong);
        denominatorLong=Math.abs(denominatorLong);

        if(numeratorLong % denominatorLong ==0)
        {
            String res =String.valueOf(numeratorLong/denominatorLong);
            if(!positive)
            {
                res = "-"+res;
            }
            return res;
        }
        //先算小数点前的
        long integer = numeratorLong / denominatorLong;
        long num = numeratorLong % denominatorLong;

        List<Long> resList = new ArrayList<Long>();
        List<Long> yushu = new ArrayList<Long>();

        boolean circu = false;
        long circuIndex = 0;
        while(num % denominatorLong != 0 && !yushu.contains(num))
        {
            yushu.add(num);
            long resTemp = num * 10 / denominatorLong;
            resList.add(resTemp);
            num = num * 10 % denominatorLong;
            if(yushu.contains(num))
            {
                circu = true;
                circuIndex = yushu.indexOf(num);
            }
        }

        String res = String.valueOf(integer) + ".";

        for(int i=0;i<resList.size();i++)
        {
            if(circu && i==circuIndex)
            {
                res +="(";
            }
            res += resList.get(i).toString();
        }
        if(circu)
        {
            res +=")";
        }
        if(!positive)
        {
            res = "-"+res;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String res = s.fractionToDecimal(-2147483648,1);
        System.out.print(res);
    }

}
