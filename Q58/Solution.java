package Q58;

import java.awt.*;

public class Solution {
        public int lengthOfLastWord(String s) {
            StringBuffer sb = new StringBuffer(s);
            sb.reverse();
            int index = 0;
            int count = 0;
//            if (sb.length()==1)
////            {
////                if(sb.charAt(0)==' ')
////                {
////                    return 0;
////                }
////                else
////                {
////                    return 1;
////                }
////            }
            while(true)
            {
                if(index >= sb.length())
                {
                    break;
                }
                if(sb.charAt(index)==' ' && count==0)
                {
                    index ++;
                }
                else if(sb.charAt(index)!=' ')
                {
                    count ++;
                    index ++;
                }
                else
                {
                    break;
                }
            }
            return count;
        }

    public static void main(String args[])
    {
       String s = " a  ";
       Solution solution = new Solution();
      System.out.println(solution.lengthOfLastWord(s));
    }

}