package Q476;

/**
 * @author OumaNatsumi
 */
class Solution
{
    public int findComplement(int num)
    {
        char[] bin = Integer.toBinaryString(num).toCharArray();
        for(int i =0;i<bin.length;i++)
        {
            bin[i] = bin[i]=='1' ? '0' : '1';
        }
        return Integer.parseInt(String.copyValueOf(bin),2);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int res = s.findComplement(1);
        System.out.println(res);
    }

}
