package leetcode._1947;

import utils.ArrayUtils;

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

    /**
     * 状态压缩 + 动态规划
     * @param students
     * @param mentors
     * @return
     */
    public int maxCompatibilitySum1(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        int[] stu = new int[m];
        int[] men = new int[m];

        for (int i = 0; i < m; i++) {
            stu[i] = arrayToInt(students[i]);
            men[i] = arrayToInt(mentors[i]);
        }

        int[][] g = new int[m][m];
        for (int i = 0; i < m; i++) { // 遍历学生
            for (int j = 0; j < m; j++) { // 遍历老师
                g[i][j] = n - Integer.bitCount(stu[i] ^ men[j]); // 学生 i 到 老师 j 的兼容性和
            }
        }

        int max = 1 << m;
        int[] dp = new int[max];
        for (int mask = 1; mask < max; mask++) {
            int stuNo = Integer.bitCount(mask);
            for (int i = 0; i < m; i++) {
                // 遍历当前老师分配状态的每一位，剔除他，将 stuNo - 1 号学生分配给他
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << i)] + g[stuNo - 1][i]);
                }
            }
        }
        return dp[max - 1];
    }

    private int arrayToInt(int[] binArr) {
        int res = 0;
        for (int j : binArr) {
            res = res << 1 | j;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumCompatibilityScoreSum mc = new MaximumCompatibilityScoreSum();
        int[][] students = new int[][] {{1,0,1},{0,0,1},{1,1,0}};
        int[][] mentors = new int[][] {{1,1,1},{0,1,1},{0,0,0}};
        System.out.println(mc.maxCompatibilitySum1(students, mentors));
    }
}
