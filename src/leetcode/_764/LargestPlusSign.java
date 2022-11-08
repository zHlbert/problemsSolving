package leetcode._764;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 最大加号标志
 *
 * https://leetcode.cn/problems/largest-plus-sign/
 */
public class LargestPlusSign {

    int[][] grid;
    int[][][] md;
    int n;
    int[][] d = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        this.n = n;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        md = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(md[i][j], -1);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int od = n;
                for (int k = 0; k < 4; k++) {
                    od = Math.min(od, search(i, j, k));
                }
                res = Math.max(res, od);
            }
        }

        return res;
    }

    /**
     * 记忆化搜索
     * @param x
     * @param y
     * @param k
     * @return
     */
    private int search(int x, int y, int k) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (md[x][y][k] != -1) {
            return md[x][y][k];
        }

        if (grid[x][y] == 0) {
            return md[x][y][k] = 0;
        }

        int[] dr = d[k];
        // 当前方向上最大长度
        int dl = 1 + search(x + dr[0], y + dr[1], k);
        return md[x][y][k] = dl;
    }

    /**
     * 动态规划
     * @param n
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign1(int n, int[][] mines) {
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                left[i][j] = grid[i][j] == 1 ? (j == 0 ? 1 : left[i][j - 1] + 1) : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = grid[i][j] == 1 ? (i == 0 ? 1 : up[i - 1][j] + 1) : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                right[i][j] = grid[i][j] == 1 ? (j == n - 1 ? 1 : right[i][j + 1] + 1) : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = grid[i][j] == 1 ? (i == n - 1 ? 1 : down[i + 1][j] + 1) : 0;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, Math.min(Math.min(left[i][j], up[i][j]), Math.min(right[i][j], down[i][j])));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LargestPlusSign lps = new LargestPlusSign();
        int n = 5;
        int[][] mines = new int[][] {{4,2}};
        System.out.println(lps.orderOfLargestPlusSign1(n, mines));
    }
}
