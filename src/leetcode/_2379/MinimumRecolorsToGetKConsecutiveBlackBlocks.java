package leetcode._2379;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    /**
     * 滑动窗口
     */
    public int minimumRecolors(String blocks, int k) {
        char[] bc = blocks.toCharArray();
        int n = bc.length;
        int res = k, wCnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            wCnt += (bc[i] == 'W' ? 1 : 0);
            if (i - j + 1 == k) {
                res = Math.min(res, wCnt);
                wCnt -= (bc[j++] == 'W' ? 1 : 0);
            }
        }
        return res;
    }
}
