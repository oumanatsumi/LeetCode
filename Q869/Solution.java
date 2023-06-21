package Q869;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        int base = 1;
        while(base < Math.pow(10,9))
        {
            nums.add(getNums(base));
            base = base*2;
        }

        List<Integer> ln = getNums(n);
        for(int i =0;i<nums.size();i++)
        {
            if(nums.get(i).size() == ln.size())
            {
                boolean isSame =true;
                for(int j=0;j<ln.size();j++)
                {
                    if(ln.get(j) != nums.get(i).get(j))
                    {
                        isSame = false;
                        break;
                    }
                }
                if(isSame)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Integer> getNums(int num)
    {
        List<Integer> res = new ArrayList<>();
        while (num>0)
        {
            res.add(num%10);
            num = num / 10;
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int n = 8402;
        System.out.println(s.reorderedPowerOf2(n));
    }
}
