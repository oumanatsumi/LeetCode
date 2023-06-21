package Q501_1000.Q503;

class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int size=nums.length;
        int[] res= new int[size];
        for(int i=0 ;i<size;i++)
        {
            int pos=i+1;
            while(pos%size != i)
            {
                if(nums[pos%size]>nums[i])
                {
                    res[i]=nums[pos%size];
                    break;
                }
                else
                {
                    pos=pos+1;
                }
            }
            if(pos%size == i)
            {
                res[i]=-1;
            }
        }

        return res;
    }


    public  static void main(String args[])
    {
        Q503 q503 = new Q503();
        int[] a=new int[]{1,2,1};
        int[] b =new int [3];
       b= q503.nextGreaterElements(a);
       for (int i=0;i<b.length;i++)
       {
           System.out.print(b[i]+" ");
       }
    }

}
