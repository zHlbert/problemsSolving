package leetcode._2373;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int k = 0; k < 9; k++) {
                    int r = k / 3, c = k % 3;
                    res[i][j] = Math.max(res[i][j], grid[i + r][j + c]);
                }
            }
        }
        return res;
    }

    public int[][] largestLocal1(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++)
            for (int j = 0; j < n - 2; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++)
                        res[i][j] = Math.max(res[i][j], grid[i + k][j + l]);

        return res;
    }
}
