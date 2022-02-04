package LeetCode.Q400;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int  res = s.findNthDigit(11);
        System.out.println(res);
    }


}
