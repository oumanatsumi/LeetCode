package LeetCode.Q598;

import com.sun.xml.internal.ws.policy.jaxws.SafePolicyReader;

import java.net.Socket;

/**
 * @author Ouma Natsumi
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0)
        {
            return m*n;
        }
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for(int i =0;i<ops.length;i++)
        {
            if(minRow > ops[i][0])
            {
                minRow = ops[i][0];
            }
            if(minCol > ops[i][1])
            {
                minCol = ops[i][1];
            }
        }
        return minCol*minRow;
    }
    
}
