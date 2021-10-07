package LeetCode.Q223;

public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //两个矩阵8个点
        //第一个：  左上：(ax1,ay2)
                //右上：(ax2,ay2)
                //左下：(ax1,ay1)
                //右下：(ax2,ay1)
        //第二个：  左上：(bx1,by2)
                //右上：(bx2,by2)
                //左下：(bx1,by1)
                 //右下：(bx2,by1)

        int projX1=Math.max(ax1,bx1);
        int projX2=Math.min(ax2,bx2);
        int projY1=Math.max(ay1,by1);
        int projY2=Math.min(ay2,by2);
        int overlap = 0;
        if((projX2-projX1)>0 && (projY2-projY1)>0)
        {
            overlap = (projX2-projX1)*(projY2-projY1);
        }

        int res = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - overlap;
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int res = s.computeArea(-2,-2,2,2,3,3,4,4);
        System.out.print(res);
    }

}
