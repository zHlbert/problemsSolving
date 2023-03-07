package leetcode.offer47;

public class MaxValueOfGifts {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] values = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i + 1][j + 1] = grid[i][j] + Math.max(values[i][j + 1], values[i + 1][j]);
            }
        }
        return values[m][n];
    }
}
