package contest.leetcode20220703;

/**
 * https://leetcode.cn/contest/weekly-contest-300/problems/number-of-increasing-paths-in-a-grid/
 */
public class NumberOfIncreasingPathsInAGrid {
    int mod = (int) (1e9 + 7);
    int m, n;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] grid, f;
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // f[i][j] 表示 从（x, y）出发的路径数量
        f = new int[m][n];
        this.grid = grid;
        long res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dfs(i, j)) % mod;
            }
        }
        return (int) res;
    }

    private int dfs(int x, int y) {
        if (f[x][y] > 0) {
            return f[x][y];
        }
        long cnt = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > grid[x][y]) {
                cnt = (cnt + dfs(nx, ny)) % mod;
            }
        }
        return f[x][y] = (int) cnt;
    }
}
