package Q2001_2500.Q2444;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i0 = -1,minI = -1, maxI = -1;
        long ans = 0L;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(x == minK) minI =i;
            if(x == maxK) maxI =i;
            if(x > maxK || x < minK) i0 = i;
            ans += Math.max(Math.min(minI,maxI)- i0, 0);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        long res = s.countSubarrays(new int[]{35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913},35054,945315);
        System.out.println(res);
    }
}
