package LeetCode.Q412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ouma Natsumi
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for(int i =1;i<=n;i++)
        {
            String resTemp="";
            if(i % 3 ==0)
            {
                resTemp+="Fizz";
            }
            if(i%5==0)
            {
                resTemp+="Buzz";
            }
            if("".equals(resTemp))
            {
                resTemp=String.valueOf(i);
            }
            res .add(resTemp);
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        List<String> res = s.fizzBuzz(15);
        for (String temp:res)
        {
            System.out.println(temp);
        }

    }

}
