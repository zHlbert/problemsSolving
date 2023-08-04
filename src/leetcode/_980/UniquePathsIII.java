package leetcode._980;

public class UniquePathsIII {
    static final int[] dx = new int[] {1, 0, -1, 0};
    static final int[] dy = new int[] {0, 1, 0, -1};
    int[][] grid;
    int m, n;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int c = 0;
        int x0 = 0, y0 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) c++;
                else if (grid[i][j] == 1) {
                    c++;
                    x0 = i;
                    y0 = j;
                }
            }
        }
        return dfs(x0, y0, c);
    }

    /**
     * 回溯
     * @param x
     * @param y
     * @param c
     * @return
     */
    int dfs(int x, int y, int c) {
        if (grid[x][y] == 2) {
            return c == 0 ? 1 : 0;
        }
        int t = grid[x][y];
        grid[x][y] = -1;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && (grid[nx][ny] == 0 || grid[nx][ny] == 2))
                res += dfs(x + dx[i], y + dy[i], c - 1);
        }
        grid[x][y] = t;
        return res;
    }

    public static void main(String[] args) {
        UniquePathsIII up = new UniquePathsIII();
        System.out.println(up.uniquePathsIII(new int[][] {{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
