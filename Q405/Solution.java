package LeetCode.Q405;

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String toHex(int num) {
        String res = "";
        boolean flag = num >= 0;
        if(num == 0)
        {
            return "0";
        }
        if(flag)
        {
            while(num > 0)
            {
                int temp = num %16;
                num = num / 16;
                if(temp > 9)
                {
                    switch (temp)
                    {
                        case 10:
                            res = "a" + res;
                            break;
                        case 11:
                            res = "b" + res;
                            break;
                        case 12:
                            res = "c" + res;
                            break;
                        case 13:
                            res = "d" + res;
                            break;
                        case 14:
                            res = "e" + res;
                            break;
                        case 15:
                            res = "f" + res;
                            break;
                        default:
                            break;
                    }
                }
                else
                {
                    res = Integer.toString(temp) + res;
                }
            }
        }


        //如果是负数，取反+1
        if(!flag)
        {
            List<Integer> Bin = new ArrayList<Integer>();
            num++;
            num = -num;
            while(num > 0)
            {
                int temp = num % 2;
                num = num / 2;
                Bin.add(0,temp);
            }

            int addNum = 32 - Bin.size();
            for(int i=0;i<addNum;i++)
            {
                Bin.add(0,0);
            }

            for(int i=0;i<Bin.size();i++)
            {
                Bin.set(i,1- Bin.get(i));
            }


            String res1 = "";
            for(int i=0;i< Bin.size()/4 ;i++)
            {
                int index0 = i*4;
                int temp = Bin.get(index0)*8+Bin.get(index0+1)*4+Bin.get(index0+2)*2+Bin.get(index0+3);
                if(temp<=9)
                {
                    res1 += Integer.toString(temp);
                }
                else
                {
                    switch (temp)
                    {
                        case 10:
                            res1 += "a";
                            break;
                        case 11:
                            res1 += "b";
                            break;
                        case 12:
                            res1 += "c";
                            break;
                        case 13:
                            res1 += "d";
                            break;
                        case 14:
                            res1 += "e";
                            break;
                        case 15:
                            res1 += "f";
                            break;
                        default:
                            break;
                    }
                }
            }
            return res1;
        }
        else
        {
            return res;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String res = s.toHex(0);
        System.out.print(res);
    }
}
