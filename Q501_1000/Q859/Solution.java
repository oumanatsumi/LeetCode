package Q501_1000.Q859;

import java.util.*;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()==1 || s.length()!= goal.length())
        {
            return false;
        }

        int len = s.length();
        int index=0;
        char diff1s='0',diff1g='0',diff2s='0',diff2g='0';
        List<Character> list=new ArrayList<>();
        boolean allEqual = false;
        while(index < len)
        {
            if(s.charAt(index) == goal.charAt(index))
            {
                if(list.contains(s.charAt(index)))
                {
                    allEqual =true;
                }
                else
                {
                    list.add(s.charAt(index));
                }
                index ++;
            }
            else
            {
                if(diff1s=='0')
                {
                    diff1s =s.charAt(index);
                    diff1g =goal.charAt(index);
                    index ++;
                }
                else if(diff2s=='0')
                {
                    diff2s =s.charAt(index);
                    diff2g =goal.charAt(index);
                    index ++;
                }
                else
                {
                    return false;
                }
            }
        }
        if(diff1s == '0' && allEqual)
        {
            return true;
        }
        if(diff2s=='0')
        {
            return false;
        }
        if(diff1s==diff2g && diff1g==diff2s)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Solution s =  new Solution();
        String s1= "caa";
        String s2 = "caa";
        boolean res =s.buddyStrings(s1,s2);
        System.out.println(res);
    }

}
