package Q851;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        List<Integer>[] q = new List[len];
        int[] inDeque = new int[len];

        for(int i=0;i<len;i++)
        {
            q[i] = new ArrayList<Integer>();
        }

        for(int[] rich:richer)
        {
            inDeque[rich[1]]++;
            q[rich[0]].add(rich[1]);
        }

        int[] ans = new int[len];

        for(int i=0;i<len;i++)
        {
            ans[i] = i;
        }

        //开始拓扑排序

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<len;i++)
        {
            if(inDeque[i] == 0)
            {
                queue.add(i);
            }
        }

        while(!queue.isEmpty())
        {
            int p = queue.poll();
            for(int t:q[p])
            {
                if(quiet[ans[t]]>quiet[ans[p]])
                {
                    ans[t] = ans[p];
                }
                inDeque[t]--;
                if(inDeque[t] == 0)
                {
                    queue.add(t);
                }
            }
        }
        return ans;
    }
}
