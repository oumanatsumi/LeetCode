package Q319;

class Solution {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }


    public static void main(String[] args){
        Solution s = new Solution();
        int  res = s.bulbSwitch(4);
        System.out.println(res);
    }
}
