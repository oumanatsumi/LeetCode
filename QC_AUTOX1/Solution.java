package QC_AUTOX1;

class Solution {
    public int getLengthOfWaterfallFlow(int num, int[] block) {
        int[] capacity = new int[num];
        int minIndex = 0;
        int min = 0;
        for(int bl:block){
            capacity[minIndex] += bl;
            min += bl;
            for(int i=0;i<num;i++){
                if(capacity[i]<min){
                    min = capacity[i];
                    minIndex = i;
                }
            }
        }
        int max = 0;
        for(int i=0;i<num;i++){
            max = Math.max(capacity[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.getLengthOfWaterfallFlow(3,new int[]{5,9,8,6});
        System.out.println(res);
    }

}
