package leetcode._1947;

/**
 * https://leetcode.cn/problems/maximum-compatibility-score-sum/
 */
public class MaximumCompatibilityScoreSum {
    int m, n;
    int[][] students, mentors;
    int cmp = 0, maxCmp = 0;
    boolean[] used;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        n = students[0].length;
        this.students = students;
        this.mentors = mentors;
        used = new boolean[m];
        backtrack(cmp, 0);
        return maxCmp;
    }

    private void backtrack(int cmp, int c) {
        if (c == m) {
            maxCmp = Math.max(maxCmp, cmp);
            return;
        }

        for (int i = 0; i < m; i++) {
            if (used[i]) {
                continue;
            }
            int add = 0;
            for (int j = 0; j < n; j++) {
                add += (students[c][j] == mentors[i][j] ? 1 : 0);
            }
            used[i] = true;
            backtrack(cmp + add, c + 1);
            used[i] = false;
        }
    }
}
