package contest.leetcode20220814;

import utils.ArrayUtils;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        res[i - 1][j - 1] = Math.max(res[i - 1][j - 1], grid[k][l]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestLocalValuesInAMatrix ll = new LargestLocalValuesInAMatrix();
        int[][] grid = new int[][] {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] res = ll.largestLocal(grid);
        ArrayUtils.print2DArray(res);
    }
}
