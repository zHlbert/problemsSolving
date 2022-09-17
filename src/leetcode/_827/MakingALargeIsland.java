package leetcode._827;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    int[] d = {0, 1, 0, -1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 1;
        int[][] tag = new int[n][n];
        int[] area = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = n * i + j + 1;
                    area[t] = dfs(grid, i, j, tag, t);
                    res = Math.max(res, area[t]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    continue;
                int s = 1;
                Set<Integer> connected = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int x = i + d[k], y = j + d[k + 1];
                    if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y]))
                        continue;
                    s += area[tag[x][y]];
                    connected.add(tag[x][y]);
                }
                res = Math.max(res, s);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
        int res = 1, n = grid.length;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i], ny = y + d[i + 1];
            if (valid(n, nx, ny) && grid[nx][ny] == 1 && tag[nx][ny] == 0) {
                res += dfs(grid, nx, ny, tag, t);
            }
        }
        return res;
    }

    private boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
