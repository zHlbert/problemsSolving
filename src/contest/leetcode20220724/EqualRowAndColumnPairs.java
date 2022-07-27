package contest.leetcode20220724;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        break;
                    }
                    if (k == n - 1) {
                        res ++;
                    }
                }
            }
        }
        return res;
    }
}
