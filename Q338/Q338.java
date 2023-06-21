package Q338;

import java.util.ArrayList;
import java.util.List;

class Q338 {
    public static int[] countBits(int num) {
        List<Integer> numList=new ArrayList<Integer>();
        numList.add(0);
        numList.add(1);
        int count=2;
        while(count <= num)
        {
            double n = 2;//底数
            double m = count;//指数
            int value = (int) (Math.log(m) / Math.log(n)) ;
            int partLength = (int)Math.pow(2,value);
            if(count-partLength >= partLength/2)
            {
                int temp=numList.get(count-partLength/2)+1;
                numList.add(temp);
            }
            else
            {
                int temp=numList.get(count-partLength/2);
                numList.add(temp);
            }
            count++;
        }
        if(num==0)
        {
            return new int[]{0};
        }
        int[] ids_int = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            ids_int[i] = numList.get(i);
        }
        return ids_int;
    }
    public static void main(String args[])
    {
        int[] a = Q338.countBits(5);
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
