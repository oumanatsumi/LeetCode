package Q2001_2500.Q2446;

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int startTime1Hour = Integer.parseInt(event1[0].substring(0,2));
        int startTime1Min = Integer.parseInt(event1[0].substring(3,5));
        int EndTime1Hour = Integer.parseInt(event1[1].substring(0,2));
        int EndTime1Min = Integer.parseInt(event1[1].substring(3,5));
        int startTime2Hour = Integer.parseInt(event2[0].substring(0,2));
        int startTime2Min = Integer.parseInt(event2[0].substring(3,5));
        int EndTime2Hour = Integer.parseInt(event2[1].substring(0,2));
        int EndTime2Min = Integer.parseInt(event2[1].substring(3,5));

        int s1 = startTime1Hour*60 + startTime1Min;
        int e1 = EndTime1Hour*60+ EndTime1Min;
        int s2 = startTime2Hour*60 + startTime2Min;
        int e2 = EndTime2Hour*60+ EndTime2Min;
        if(e1 < s2 || e2 < s1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] e1 ={"01:15","02:00"};
        String[] e2 ={"02:00","03:00"};
        boolean r = s.haveConflict(e1,e2);
    }
}
