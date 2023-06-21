package QC341_3;

class Solution {

    public int addMinimum(String word) {
        int stat = 0; // 0a1b2c
        StringBuilder sb = new StringBuilder(word);
        int index = 0;
        int ans = 0;
        while(index < sb.length()){
            if(sb.charAt(index)!= 'a' + stat){
                sb.insert(index, (char) ('a'+ stat));
                ans ++;
            }
            index ++;
            stat = (stat+1) %3;
        }
        if(sb.charAt(sb.length()-1) == 'c'){
            return ans;
        }else if(sb.charAt(sb.length()-1) == 'b'){
            return ans +1;
        }else {
            return ans +2;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addMinimum("b");
    }
}
