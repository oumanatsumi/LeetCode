package Q1664;

public class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length,n1 = n / 2,n2;
        if(n == 1) return 1;
        boolean isOdd = n % 2 == 1;
        if(!isOdd) n2 = n /2;
        else n2 = (n / 2) +1;

        int[] prefixOdd = new int[n1];
        int[] prefixEven = new int[n2];

        prefixEven[0] = nums[0];
        prefixOdd[0] = nums[1];
        for (int i = 2; i < n; i++) {
            if(i%2 == 0) prefixEven[i/2] = prefixEven[i/2-1] +nums[i];
            else prefixOdd[i/2] = prefixOdd[i/2-1] +nums[i];
        }
        //  预处理结束
        int OddSum = prefixOdd[n1-1];
        int EvenSum = prefixEven[n2-1];
        int OddTemp = 0, EvenTemp = 0;
        int ans = 0;
        //i == 0
        if(EvenSum - nums[0] == OddSum) ans++;
        //i == 1
        if(nums[0] + OddSum - nums[1] == EvenSum - nums[0]) ans++;
        for (int i = 2; i < n; i++) {
            if(i % 2 == 0){
                EvenTemp = prefixEven[i/2 -1] + OddSum - prefixOdd[i/2 -1];
                OddTemp =  prefixOdd[i/2 -1] + EvenSum - prefixEven[i/2 -1] - nums[i];
            }else {
                EvenTemp = prefixEven[(i+1)/2 -1] + OddSum - prefixOdd[i/2 -1] - nums[i];
                OddTemp =  prefixOdd[i/2 -1] + EvenSum - prefixEven[(i+1)/2 -1];
            }
            if(EvenTemp == OddTemp) ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.waysToMakeFair(new int[]{1,1,1,1,1});
    }


}
