package Q795;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 单调栈解法
//    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//        Deque<Integer> dq = new LinkedList<>();
//        int res = 0;
//        int div = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= left && nums[i] <= right) {
//                if (dq.isEmpty()) dq.push(i);
//                else {
//                    while (!dq.isEmpty() && dq.peek() < nums[i]) {
//                        int curIndex = dq.poll();
//                        res += dq.isEmpty() ? (curIndex - div) * (i - curIndex) : (curIndex - dq.peek()) * (i - curIndex);
//                    }
//                    dq.push(i);
//                }
//            } else if (nums[i] > right) {
//                while (!dq.isEmpty()) {
//                    int curIndex = dq.poll();
//                    res += dq.isEmpty() ? (curIndex - div) * (i - curIndex) : (curIndex - dq.peek()) * (i - curIndex);
//                }
//                div = i;
//            }
//        }
//        while (!dq.isEmpty()) {
//            int curIndex = dq.poll();
//            res += dq.isEmpty() ? (curIndex - div) * (nums.length - curIndex) : (curIndex - dq.peek()) * (nums.length - curIndex);
//        }
//
//        return res;
//    }


    // 巧妙计数法（官解二）
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, temp = 0;
        for(int i: nums){
            if(i <= right) res += ++temp;
            else temp = 0;
        }
        temp = 0;
        for(int i:nums){
            if(i < left) res -= ++temp;
            else temp = 0;
        }
        return res;
    }
}
