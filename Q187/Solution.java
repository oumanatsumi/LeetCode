package LeetCode.Q187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s)
    {
        Map<String,Integer> map=new HashMap<String,Integer>();
        int left=0;
        int right=10;
        while(right<=s.length())
        {
            String sub = s.substring(left,right);
            if(map.containsKey(sub))
            {
                map.put(sub,map.get(sub)+1);
            }
            else
            {
                map.put(sub,0);
            }
            left++;
            right++;
        }

        List<String> res = new ArrayList<String>();
        for(String key:map.keySet())
        {
            if(map.get(key)>0)
            {
                res.add(key);
            }

        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String ss="AAAAAAAAAAA";
        List<String> res = s.findRepeatedDnaSequences(ss);
        for(int i=0;i<res.size();i++)
        {
            System.out.println(res.get(i));
        }
    }

}
