package SPOffer.SPOffer57_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    // 方法一 ：数学
//    public int[][] findContinuousSequence(int target) {
//        List<int[]> resList = new ArrayList<>();
//        for (int i = 1; i <= target/2; i++) {
//            double tmp = Math.sqrt(8L * target + 4L * i * i - 4L *i + 1 );
//            if(Math.ceil(tmp) == tmp && Math.ceil(tmp)% 2 == 1){
//                resList.add(IntStream.range(i, (int) ((Math.ceil(tmp) - 1) /2)+1)
//                        .boxed().mapToInt(e -> e)
//                        .toArray());
//            }
//        }
//        return resList.toArray(new int[0][0]);
//    }

    // 方法二：双指针滑动窗口
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        List<int[]> resList = new ArrayList<>();
        while (left < target && right < target){
            if((left + right) * (right - left +1)/2 == target){
                resList.add(IntStream.range(left, right+1)
                        .boxed().
                        mapToInt(e -> e)
                        .toArray());
                left ++;
            }else if((left + right) * (right - left +1)/2 < target){
                right ++ ;
            }else {
                left ++;
            }
        }
        return resList.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findContinuousSequence(9);
    }
}
