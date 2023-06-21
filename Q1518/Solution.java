package Q1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while(numBottles>=numExchange)
        {
            int exchange = numBottles / numExchange;
            total += exchange;
            numBottles = exchange + numBottles % numExchange;
        }
        return total;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int res = s.numWaterBottles(2,5);
        System.out.println(res);
    }
}
