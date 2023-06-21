package Q1_500.Q229;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ouma Natsumi
 */
class Solution {
//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> res = new ArrayList<Integer>();
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num:nums) {
//            if(map.containsKey(num))
//            {
//                map.put(num,map.get(num)+1);
//            }
//            else
//            {
//                map.put(num,1);
//            }
//        }
//        for (Integer key:map.keySet())
//        {
//            if(map.get(key)>nums.length/3)
//            {
//                res.add(key);
//            }
//        }
//        return res;
//    }

// 摩尔投票法

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count1=0;
        int count2=0;
        int cand1=nums[0];
        int cand2=nums[0];
        for (int num:nums) {
            if(cand1==num)
            {
                count1++;
                continue;
            }
            if(cand2==num)
            {
                count2++;
                continue;
            }
            if(count1==0)
            {
                cand1=num;
                count1++;
                continue;
            }
            if(count2==0)
            {
                cand2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        int cnt1=0;
        int cnt2=0;
        for(int num:nums)
        {
            if(cand1==num)
            {
                cnt1++;
            }
            if(cand2==num)
            {
                cnt2++;
            }
        }
        if(cnt1>nums.length/3)
        {
            res.add(cand1);
        }
        if(cnt2>nums.length/3 && cand1!=cand2)
        {
            res.add(cand2);
        }

        return res;
    }
}
