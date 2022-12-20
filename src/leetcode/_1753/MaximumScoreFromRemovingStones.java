package leetcode._1753;

public class MaximumScoreFromRemovingStones {
    /**
     * 贪心
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int maximumScore(int a, int b, int c) {
        int s = a + b + c;
        int m = Math.max(a, Math.max(b, c));
        return s - m <= m ? s - m : s >> 1;
    }
}
