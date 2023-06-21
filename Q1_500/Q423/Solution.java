package Q1_500.Q423;

import java.util.*;

class Solution {
    Map<Character,Integer>[] maps = new Map[10];

    public String originalDigits(String s) {
        generateMaps();
        Map<Character,Integer> sMap = new HashMap<>();
        List<Integer> res= new ArrayList<>();
        char[] temp = s.toCharArray();
        for (char c:temp) {
            if(sMap.containsKey(c))
            {
                sMap.put(c,sMap.get(c)+1);
            }
            else
            {
                sMap.put(c,1);
            }
        }
        int index = 0 ;
        int[] seq ={0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
        while (index < 10)
        {
            boolean flag = true;
            for(Character key:maps[seq[index]].keySet())
            {
                if(!sMap.containsKey(key))
                {
                    flag = false;
                    break;
                }
                else
                {
                    if(sMap.get(key)<maps[seq[index]].get(key))
                    {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
            {
                for(Character key:maps[seq[index]].keySet())
                {
                    sMap.put(key,sMap.get(key)-maps[seq[index]].get(key));
                }
                res.add(seq[index]);
            }
            else
            {
                index++;
            }
        }
        String ans = "";
        Collections.sort(res);
        for (Integer i:res) {
            ans += i.toString();
        }
        return ans.toString();
    }

    private void generateMaps()
    {
        for(int i =0 ;i<10;i++)
        {
            maps[i] = new HashMap();
        }
        maps[0].put('z',1);
        maps[0].put('e',1);
        maps[0].put('r',1);
        maps[0].put('o',1);


        maps[1].put('o',1);
        maps[1].put('n',1);
        maps[1].put('e',1);

        maps[2].put('t',1);
        maps[2].put('w',1);
        maps[2].put('o',1);

        maps[3].put('t',1);
        maps[3].put('h',1);
        maps[3].put('r',1);
        maps[3].put('e',2);

        maps[4].put('f',1);
        maps[4].put('o',1);
        maps[4].put('u',1);
        maps[4].put('r',1);

        maps[5].put('f',1);
        maps[5].put('i',1);
        maps[5].put('v',1);
        maps[5].put('e',1);

        maps[6].put('s',1);
        maps[6].put('i',1);
        maps[6].put('x',1);

        maps[7].put('s',1);
        maps[7].put('e',2);
        maps[7].put('v',1);
        maps[7].put('n',1);

        maps[8].put('e',1);
        maps[8].put('i',1);
        maps[8].put('g',1);
        maps[8].put('h',1);
        maps[8].put('t',1);

        maps[9].put('n',2);
        maps[9].put('i',1);
        maps[9].put('e',1);

    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String ss= "fviefuro";
        String res = s.originalDigits(ss);

        System.out.println(res);
    }

}
