package Q1129;

import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redLines = new List[n];
        List<Integer>[] blueLines = new List[n];
        for (int i = 0; i < n; i++) {
            redLines[i] = new ArrayList<>();
            blueLines[i] = new ArrayList<>();
        }

        for(int[] resEdge : redEdges){
            redLines[resEdge[0]].add(resEdge[1]);
        }
        for(int[] blueEdge : blueEdges){
            blueLines[blueEdge[0]].add(blueEdge[1]);
        }
        int[] resRed = new int[n];
        int[] resBlue = new int[n];
        Arrays.fill(resRed,Integer.MAX_VALUE);
        Arrays.fill(resBlue,Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        // {0,0} 的第一个0表示出发点为0，第二个0表示下次要走红色（1则表示蓝色）
        queue.offer(new int[]{0,0});
        queue.offer(new int[]{0,1});
        int level = 0;
        int size = queue.size();
        while (!queue.isEmpty()){
            level++;
            size = queue.size();
            for(int i = 0; i< size ;i++){
                int[] cur = queue.poll();
                if(cur[1] == 0) // 下条边是红的
                {
                    for(Integer line: redLines[cur[0]]){
                        if(resRed[line] > level){
                            resRed[line] = level;
                            queue.offer(new int[]{line,1});
                        }
                    }
                }else {
                    for(Integer line: blueLines[cur[0]]){
                        if(resBlue[line] > level){
                            resBlue[line] = level;
                            queue.offer(new int[]{line,0});
                        }
                    }
                }
            }
        }

        int[] res = new int[n];
        res[0] = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(resRed[i], resBlue[i]);
            res[i] = temp== Integer.MAX_VALUE ? -1 : temp;
        }
        return res;
    }
}
