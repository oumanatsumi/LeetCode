package Q517;

class Solution {
    public int findMinMoves(int[] machines) {
        int len = machines.length;
        int sum=0;
        int max=0;
        for(int i=0;i<len;i++)
        {
            sum+=machines[i];
        }
        if(sum % len != 0)
        {
            return -1;
        }
        int avg = sum / len;
        int[] avgDiff = new int[len];
        for(int i=0;i<len;i++)
        {
            avgDiff[i] = machines[i]-avg;
            if(avgDiff[i]>max)
            {
                max = avgDiff[i];
            }
        }
        //算前缀和

        int diffMaxNum = -999;
        int temp=0;
        for(int i=0;i<len;i++)
        {
            temp += avgDiff[i];
            if(diffMaxNum < Math.abs(temp))
            {
                diffMaxNum = Math.abs(temp);
            }
        }

        if(diffMaxNum > max)
        {
            return diffMaxNum;
        }
        else
        {
            return max;
        }

    }
}