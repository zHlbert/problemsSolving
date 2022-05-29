package contest.leetcode20220529;

/**
 * https://leetcode.cn/contest/weekly-contest-295/problems/minimum-obstacle-removal-to-reach-corner/
 */
public class MinimumObstacleRemovalToReachCorner {
    int[][] d = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    int minOb;
    int m, n;
    int[][] grid;
    public int minimumObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        minOb = m * n + 1;
        this.grid = grid;
        backtrack(0, 0, 0);
        return minOb;
    }

    private void backtrack(int row, int col, int ob) {
        if (ob > minOb) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            minOb = ob;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = row + d[i][0];
            int nc = col + d[i][1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                int oVal = grid[nr][nc];
                if (oVal != 2) {
                    grid[nr][nc] = 2;
                    backtrack(nr, nc, ob + oVal);
                    grid[nr][nc] = oVal;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner mor = new MinimumObstacleRemovalToReachCorner();
//        int[][] grid = new int[][] {{0,1,1},{1,1,0},{1,1,0}};
        int[][] grid = new int[][] {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        System.out.println(mor.minimumObstacles(grid));
    }
}
