package leetcode._221;

import utils.ArrayUtils;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxL = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0 || j == 0) ? 1
                            : Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxL = Math.max(maxL, dp[i][j]);
                }
            }
        }
//        ArrayUtils.print2DArray(dp);
        return maxL * maxL;
    }

    public static void main(String[] args) {
        MaximalSquare m = new MaximalSquare();
//        char[][] matrix = new char[][] {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','0','1','1','1'},
//                {'1','0','0','1','0'}};
//        char[][] matrix = new char[][] {
//                {'0','1'},
//                {'1','0'}
//        };
        char[][] matrix = new char[][] {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
//        char[][] matrix = new char[][] {{'1','1'}};
        System.out.println(m.maximalSquare(matrix));
    }
}
