package Q434;

public class Solution {
    public int countSegments(String s) {
        if(s.equals(""))
        {
            return 0;
        }
        else
        {
            String[] strings=s.split(" ");
            int len = strings.length;
            for(int i=0;i<strings.length;i++)
            {
                if(strings[i].equals(""))
                {
                    len--;
                }
            }
            return len;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String ss=", , , ,        a, eaefa";
        int res = s.countSegments(ss);
        System.out.println(res);
    }
}
