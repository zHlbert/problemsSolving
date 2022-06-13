package leetcode._498;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/problems/diagonal-traverse/
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;
        boolean xDown = true;
        for (int i = 0; i < m + n - 1; i++) {
            int x1 = Math.min(i, m - 1);
            int x2 = Math.max(0, i + 1 - n);
            if (xDown) {
                for (int j = x1; j >= x2; j--) {
                    res[idx++] = mat[j][i - j];
                }
                xDown = false;
            } else {
                for (int j = x2; j <= x1; j++) {
                    res[idx++] = mat[j][i - j];
                }
                xDown = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
//        int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = new int[][] {{1,2},{3,4},{5,6}};
        ArrayUtils.printArray(dt.findDiagonalOrder(mat));
    }
}
