package Q482;

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        s = s.toUpperCase();
        int len = s.length();
        int groupNum = len / k;
        int firstGroupNum = len % k;
        String res = "";
        //第一组
        for(int i = 0;i<firstGroupNum;i++)
        {
            res += s.charAt(i);
        }
        for(int i =0;i<groupNum;i++)
        {
            if(firstGroupNum!=0 || i!=0)
            {
                res += "-";
            }
            res += s.substring(i*k+firstGroupNum,i*k+firstGroupNum+k);
        }

        return res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        String res = s.licenseKeyFormatting("35F3Z-2e-9-w",4);
        System.out.print(res);
    }

}
