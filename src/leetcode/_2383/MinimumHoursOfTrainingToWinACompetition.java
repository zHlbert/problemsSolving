package leetcode._2383;

public class MinimumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ex = 0, sumEn = 0, sumEx = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            sumEn += energy[i];
            ex = Math.max(ex, Math.max(0, experience[i] - sumEx + 1));
            sumEx += experience[i];
        }
        return Math.max(sumEn + 1 - initialEnergy, 0) + Math.max(ex - initialExperience, 0);
    }

    public static void main(String[] args) {
        MinimumHoursOfTrainingToWinACompetition mh = new MinimumHoursOfTrainingToWinACompetition();
        System.out.println(mh.minNumberOfHours(5, 3, new int[] {1,4,3,2}, new int[] {2,6,3,1}));
        System.out.println(mh.minNumberOfHours(2, 4, new int[] {1}, new int[] {3}));
    }
}
