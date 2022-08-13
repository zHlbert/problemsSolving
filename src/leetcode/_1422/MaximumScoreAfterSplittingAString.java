package leetcode._1422;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[][] cnts = new int[n + 1][2];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            cnts[i + 1][0] = cnts[i][0] + (sc[i] == '0' ? 1 : 0);
            cnts[j][1] = cnts[j + 1][1] + (sc[j] == '1' ? 1 : 0);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, cnts[i][0] + cnts[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumScoreAfterSplittingAString ms = new MaximumScoreAfterSplittingAString();
        String s = "1111";
        System.out.println(ms.maxScore(s));
    }
}
