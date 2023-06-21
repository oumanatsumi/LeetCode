package Q1501_2000.Q1646;

class Q1646 {
    public static int getMaximumGenerated(int n) {
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;
        if(n==0)
        {
            return 0;
        }
        int max = 1;
        for(int index=2; index <=n;index++)
        {
            if(index % 2 == 0)
            {
                res[index] = res[index/2];
                if(res[index]>max)
                {
                    max = res[index];
                }
            }
            else
            {
                res[index] = res[index/2]+res[index/2 +1];
                if(res[index]>max)
                {
                    max = res[index];
                }
            }
        }


        return max;
    }

    public  static void main(String args[])
    {
        Q1646 q=new Q1646();
        System.out.print(getMaximumGenerated(7));

    }

}
