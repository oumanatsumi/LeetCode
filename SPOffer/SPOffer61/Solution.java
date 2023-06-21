package SPOffer.SPOffer61;

class Solution {
    public boolean isStraight(int[] nums) {
        int[] map = new int[14];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map[nums[i]]++;
        }
        int cur = -1;
        for (int i = 1; i < 14; i++) {
            if(map[i] == 1){
                if(cur == -1) cur = i;
                else {
                    if(i == cur + 1){
                        cur ++;
                    }
                    else {
                        if(map[0] > 0){
                            map[0] --;
                            i--;
                            cur ++;
                        }else {
                            return false;
                        }
                    }
                }
            }else if(map[i] > 1) return false;
        }
        return true;
    }
}
