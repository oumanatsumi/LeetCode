package QustionContests.QC342_1;

class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime) %24;
    }
}
