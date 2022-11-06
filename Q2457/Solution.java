package Q2457;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long ans = 0;
        List<Integer> list = cal(n);
        int index = 0;
        while (target < getTotal(list)){
            long add = (long) ((10-list.get(index))*Math.pow(10,index));
            ans += add;
            long newN = returnNum(list, add);
            list = cal(newN);
            index++;
        }
        return ans;
    }

    private long returnNum(List<Integer> l,long add){
        long ans = 0;
        for (int i = 0; i < l.size(); i++) {
            ans += l.get(i)*Math.pow(10,i);
        }
        return ans + add;
    }

    private List<Integer> cal(long n){
        List<Integer> res = new ArrayList<>();
        while (n>0) {
            res.add((int) (n%10));
            n /= 10;
        }
        return res;
    }

    private int getTotal(List<Integer> l){
        int ans = 0;
        for(Integer i : l){
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long a = s.makeIntegerBeautiful(467,6);
    }
}
