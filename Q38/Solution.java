package Q38;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public String countAndSay(int n) {
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        for(int i = 2;i<=n;i++)
        {
            String temp = describe(list.get(i-1));
            list.add(temp);
        }
        return list.get(n);
    }

    private String describe(String num) {
        int tempCount = 1;
        char curLetter = num.charAt(0);
        String res="";
        for(int i = 1 ;i<num.length();i++)
        {
            if(curLetter == num.charAt(i))
            {
                tempCount++;
            }
            else
            {
                res += String.valueOf(tempCount);
                res += curLetter;
                curLetter = num.charAt(i);
                tempCount = 1;
            }
        }
        res += String.valueOf(tempCount);
        res += curLetter;

        return res;
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        String res = s.countAndSay(1);
        System.out.println(res);
    }

}
