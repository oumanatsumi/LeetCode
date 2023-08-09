package Q1_500.Q287;

class Solution {
    //  方法1：Set
    //  方法2：位运算
//    public int findDuplicate(int[] nums) {
//        int bitMax = 18;
//        int n = nums.length;
//        int res = 0;
//        for (int i = 0; i < bitMax; i++) {
//            int x= 0,y = 0;
//            for (int j = 0; j < n; j++) {
//                if((nums[j] >> i & 1) == 1){
//                    x++;
//                }
//                if((j >> i & 1 )== 1){
//                    y++;
//                }
//            }
//            if(x > y) res |= (1 << i);
//        }
//        return res;
//    }
    public int findDuplicate(int[] nums) {
        // 方法三：快慢指针
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(res);
    }
}
