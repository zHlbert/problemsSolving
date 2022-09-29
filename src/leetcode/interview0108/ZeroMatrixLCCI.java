package leetcode.interview0108;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class ZeroMatrixLCCI {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> zxy = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zxy.add(new int[] {i, j});
                }
            }
        }
        for (int[] xy : zxy) {
            int x = xy[0], y = xy[1];
            for (int i = 0; i < n; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }
        }
    }

    /**
     * 首列标记 行列置0
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean col0zero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0zero = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 1; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0zero) {
                matrix[i][0] = 0;
            }
        }
    }
}
