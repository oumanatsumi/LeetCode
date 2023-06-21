package Q2001_2500.Q2483;

class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] log = new int[n];
        for (int i = 0; i < n; i++) {
            if(customers.charAt(i) == 'Y') log[i] =1;
            else log[i] = 0;
        }
        int[] sub = new int[n];
        sub[0] = log[0];
        for (int i = 1; i < n; i++) {
            sub[i] = sub[i-1] + log[i];
        }
        // 不开门 或 不关门
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        if(sub[n-1] < n - sub[n-1]){
            minIndex = 0;
            min = sub[n-1];
        }else {
            minIndex = n;
            min = n - sub[n-1];
        }

        //正常开门
        for (int i = 1; i < sub.length; i++) {
            int cod1 = i - sub[i-1];
            int cod2 = sub[sub.length-1] - sub[i-1];
            if(cod1 + cod2 < min){
                min = cod1 + cod2;
                minIndex = i;
            }else if(cod1 + cod2 == min){
                if(i < minIndex){
                    min = cod1 + cod2;
                    minIndex = i;
                }
            }
        }
        return minIndex;
        
    }
}
