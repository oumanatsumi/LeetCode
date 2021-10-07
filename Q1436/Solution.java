package LeetCode.Q1436;

import javax.swing.plaf.synth.SynthUI;
import java.util.*;

public class Solution {
    public String destCity(List<List<String>> paths) {
        String res="";
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<paths.size();i++)
        {
            String begin = paths.get(i).get(0);
            String end = paths.get(i).get(1);
            if(map.containsKey(begin))
            {
                map.put(begin,map.get(begin)-1);
            }
            else
            {
                map.put(begin,1);
            }

            if(map.containsKey(end))
            {
                map.put(end,map.get(end)+1);
            }
            else
            {
                map.put(end,-1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == -1)
            {
                res=entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        List<List<String>> paths = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        temp.add("A");
        temp.add("Z");
        paths.add(temp);
        temp.clear();
        temp.add("Z");
        temp.add("B");
        paths.add(temp);
        temp.clear();
        temp.add("B");
        temp.add("C");
        paths.add(temp);





        Solution s = new Solution();
        String res = s.destCity(paths);
        System.out.print(res);
    }
}
