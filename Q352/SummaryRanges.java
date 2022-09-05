package Q352;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SummaryRanges {
    private List<Integer> numList;
    public SummaryRanges() {
        numList = new ArrayList<Integer>();
    }

    public void addNum(int val) {
        numList.add(val);
        Collections.sort(numList);
    }

    public int[][] getIntervals() {
        int index = 0;
        int[][] res = new int[numList.size()][2];
        int resIndex = 0;
        res[resIndex][0]=numList.get(0);
        res[resIndex][1]=numList.get(0);

        while(index < numList.size()-1)
        {
            if(numList.get(index+1)-numList.get(index)<=1)
            {
                index++;
                res[resIndex][1]=numList.get(index);
            }
            else
            {
                resIndex++;
                index++;
                res[resIndex][0]=numList.get(index);
                res[resIndex][1]=numList.get(index);
            }
        }

        int[][] realRes = new int[resIndex+1][2];
        for(int i=0;i<=resIndex;i++)
        {
            realRes[i][0]=res[i][0];
            realRes[i][1]=res[i][1];
        }



        return realRes;
    }

    public static void main(String[] args)
    {
        SummaryRanges s = new SummaryRanges();

        s.addNum(1);
        s.addNum(2);
        s.addNum(3);
        s.addNum(6);
        s.addNum(6);
        s.addNum(8);
        s.addNum(11);
        s.addNum(15);
        int[][] res = s.getIntervals();
        for(int i =0;i<res.length;i++)
        {
            System.out.println(res[i][0]+","+res[i][1]);
        }

    }



}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */