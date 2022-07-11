package leetcode._1252;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
public class CellsWithOddValuesInAMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                mat[index[0]][i] ^= 1;
            }
            for (int i = 0; i < m; i++) {
                mat[i][index[1]] ^= 1;
            }
        }

        int res = 0;
        for (int[] row : mat) {
            for (int i : row) {
                res += (i == 1 ? 1 : 0);
            }
        }
        return res;
    }

    public int oddCells1(int m, int n, int[][] indices) {
        // 第 i 行累加结果是否为奇数
        boolean[] rows = new boolean[m];
        // 第 i 列累加结果是否为奇数
        boolean[] cols = new boolean[n];
        for (int[] index : indices) {
            rows[index[0]] = !rows[index[0]];
            cols[index[1]] = !cols[index[1]];
        }

        // oddx 累加次数为奇数的行数
        // oddy 累加次数为偶数的行数
        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            oddx += rows[i] ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            oddy += cols[i] ? 1 : 0;
        }

        // 矩阵中位于 (x, y) 位置的数为奇数，当且仅当 rows[x] 和 cols[y] 中恰好有一个为奇数，一个为偶数
        // 如果 rows[x] 为偶数，该行有 oddy 个位置为奇数，则有 oddy * (m - oddx) 个奇数
        // 如果 rows[x] 为奇数，该行有 n - oddy 个位置为奇数，则有 oddx * (n - oddy) 个奇数
        return oddx * (n - oddy) + oddy * (m - oddx);
    }

    public static void main(String[] args) {
        CellsWithOddValuesInAMatrix cov = new CellsWithOddValuesInAMatrix();
        int m = 2, n = 3;
        int[][] indices = new int[][] {{0,1},{1,1}};
        System.out.println(cov.oddCells(m,n,indices));
    }
}
