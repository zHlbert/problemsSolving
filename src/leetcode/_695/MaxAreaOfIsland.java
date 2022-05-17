package leetcode._695;

public class MaxAreaOfIsland {
    int m, n;
    int maxArea = 0;
    int curArea;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, this.grid[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    curArea = 0;
                    dfs(i , j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int x, int y) {
        if (!inArea(x, y)) {
            return;
        }
        if (grid[x][y] != 1) {
            return;
        }
        grid[x][y] = 2;
        curArea++;
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x - 1, y);
        dfs(x, y - 1);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int maxAreaOfIsland1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, this.grid[i], 0, n);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfsWithRes(i , j);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    private int dfsWithRes(int x, int y) {
        if (!inArea(x, y)) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;

        return 1 + dfsWithRes(x + 1, y)
                + dfsWithRes(x, y + 1)
                + dfsWithRes(x - 1, y)
                + dfsWithRes(x, y - 1);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(ma.maxAreaOfIsland(grid));
    }
}
