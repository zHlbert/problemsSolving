package leetcode._2432;

public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int pre = 0, li = 0, lm = 0;
        for (int[] log : logs) {
            int t = log[1];
            if (t - pre > lm || t - pre == lm && log[0] < li) {
                lm = t - pre;
                li = log[0];
            }
            pre = t;
        }
        return li;
    }
}
