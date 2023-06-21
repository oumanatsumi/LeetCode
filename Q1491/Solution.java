package Q1491;

class Solution {
    public double average(int[] salary) {
        int total = 0;
        int max = Math.max(salary[0],salary[1]);
        int min = Math.min(salary[0],salary[1]);
        for(int i=2;i<salary.length;i++)
        {
            if(salary[i]> max)
            {
                total+=max;
                max = salary[i];
            }
            else if(salary[i]<min)
            {
                total+=min;
                min = salary[i];
            }
            else
            {
                total+=salary[i];
            }
        }
        return (double)total / (salary.length-2);
    }
}
