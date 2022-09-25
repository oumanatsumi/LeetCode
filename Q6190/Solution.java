package Q6190;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] down = new int[n];
        int[] up = new int[n];
        // get down
        int temp = nums[0];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= temp){
                down[i] = index;
            }else {
                down[i] = i;
                index = i;
            }
            temp = nums[i];
        }
        //get up
        temp = nums[0];
        index = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] >= temp){
                up[i] = index;
            }else {
                up[i] = i;
                index = i;
            }
            temp = nums[i];
        }

        for(int i = k;i<n-k;i++){
            if(down[i-1] <= i-k && up[i+k] <= i+1){
                res.add(i);
            }
        }


        System.out.println("down:");
        for(int i:down){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("up:");
        for(int i:up){
            System.out.print(i+" ");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> res = s.goodIndices(new int[]{878724,201541,179099,98437,35765,327555,475851,598885,849470,943442},4);
        for(int i:res){
            System.out.println(i);
        }
    }
}
