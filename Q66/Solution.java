package Q66;



public class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean carry = false;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            carry = true;
            index--;
        }
        if (index < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                res[i] = 0;
            }
            return res;
        }
        digits[index] +=1;
        return digits;
    }

    public static void main(String[] args)
    {
        Solution s= new Solution();
        int [] d = {9,9,9,9,9};
        int[] res=s.plusOne(d);
        for (int i:res
             ) {
            System.out.println(i);
        }
    }



}
