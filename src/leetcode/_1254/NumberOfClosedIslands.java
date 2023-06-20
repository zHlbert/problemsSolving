package leetcode._1254;

public class NumberOfClosedIslands {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    int[][] grid;
    int m, n;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res += dfs(i, j) ? 1 : 0;
                }
            }
        }
        return res;
    }

    private boolean dfs(int x, int y) {
        if (offBorder(x, y)) return false;
        if (grid[x][y] != 0) return true;
        grid[x][y] = 2;
        boolean ret1 = dfs(x - 1, y);
        boolean ret2 = dfs(x + 1, y);
        boolean ret3 = dfs(x, y - 1);
        boolean ret4 = dfs(x, y + 1);
        return ret1 && ret2 && ret3 && ret4;
    }

    private boolean offBorder(int x, int y) {
        return x < 0 || x == m || y < 0 || y == n;
    }
}
