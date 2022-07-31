package contest.leetcode20220731;

/**
 * https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/
 */
public class MaximumNumberOfGroupsEnteringACompetition {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int i = 1;
        for (; i < 1000; i++) {
            if (i * (i + 1) > 2 * n) {
                break;
            }
        }
        return i - 1;
    }
    // TODO: 2022/7/31 二分
}
