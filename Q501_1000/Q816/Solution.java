package Q501_1000.Q816;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String ss = s.substring(1,s.length()-1);
        int n = ss.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n ; i++) {
            StringBuilder l = new StringBuilder(ss.substring(0, i));
            StringBuilder r = new StringBuilder(ss.substring(i, n));
            System.out.println(l + "," + r);

            for (int j = 0; j < l.length(); j++) {
                StringBuilder tempLeft = new StringBuilder(l);
                if(j != 0) tempLeft = tempLeft.insert(j,'.');
                if(!check(tempLeft.toString(),j)) continue;
                for (int k = 0; k < r.length(); k++) {
                    StringBuilder tempRight = new StringBuilder(r);
                    if(k != 0) tempRight = tempRight.insert(k,'.');
                    if(check(tempRight.toString(),k)){
                        String tempRes = "(" + tempLeft.toString() + ", " +tempRight.toString() + ")";
                        res.add(tempRes);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 检查是否是合法的
     * @param s 传入的子串
     * @param pointIndex 小数点的下标，如果没有小数点，传入0
     * @return
     */
    private boolean check(String s, int pointIndex){
        if(s.length() == 1) return true;
        if(s.charAt(0) == '0'){
            if(pointIndex != 1) return false;
        }
        if(s.charAt(s.length()-1) == '0' && pointIndex != 0){
            return false;
        }
        return true;
    }
}
