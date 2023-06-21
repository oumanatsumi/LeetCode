package Q1_500.Q318;

import java.util.*;

class Solution {

    public int maxProduct(String[] words) {
        int max=0;
        for(int i= 0 ;i<words.length;i++)
        {
            Set<Character> list = new HashSet<>();
            for(int a=0;a<words[i].length();a++)
            {
                Character character = words[i].charAt(a);
                list.add(character);
            }
            for(int j=1;j<words.length;j++)
            {
                boolean flag = true;
                if(words[j].length()*words[i].length()<max)
                {
                    continue;
                }
                for(int m=0;m<words[j].length();m++)
                {
                    if(list.contains(words[j].charAt(m)))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    max = words[j].length()*words[i].length();
                }
            }
        }
        return max;
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        int res = s.maxProduct(words);
        System.out.println(res);
    }

}
