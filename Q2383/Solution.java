package Q2383;

public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int requireEnergy = energy[n - 1] + 1;
        int requireExp = experience[0] + 1;
        int curExp = requireExp;
        for (int i = n - 2; i >= 0; i--) {
            requireEnergy += energy[i];
        }
        for (int i = 1; i < n; i++) {
            curExp += experience[i-1];
            if(curExp <= experience[i]){
                requireExp += (experience[i]- curExp+1);
                curExp += (experience[i]- curExp+1);
            }
        }
        int res = 0;
        if(initialExperience < requireEnergy) res += (requireEnergy - initialEnergy);
        if(initialExperience < requireExp) res += (requireExp - initialExperience);
        return res;
    }
}
