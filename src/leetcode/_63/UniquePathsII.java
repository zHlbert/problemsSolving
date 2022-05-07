package leetcode._63;

import utils.ArrayUtils;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = (i != 0 ? dp[i - 1][j] : 0) + (j != 0 ? dp[i][j - 1] : 0);
                    }
                }
            }
        }
        ArrayUtils.print2DArray(dp);
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII u = new UniquePathsII();
        int[][] obstacleGrid = new int[][] {{1,0}};
//        int[][] obstacleGrid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid));
    }
}
