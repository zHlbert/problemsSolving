package leetcode._934;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/shortest-bridge/
 */
public class ShortestBridge {
    int[] d = new int[] {1, 0, -1, 0, 1};

    int n;

    Queue<int[]> q = new ArrayDeque<>();

    int[][] grid;

    /**
     * dfs + bfs
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    int step = 0;
                    while (!q.isEmpty()) {
                        int sz = q.size();
                        for (int k = 0; k < sz; k++) {
                            int[] co = q.poll();
                            int x = co[0], y = co[1];
                            for (int l = 0; l < 4; l++) {
                                int nx = x + d[l], ny = y + d[l + 1];
                                if (inArea(nx, ny)) {
                                    if (grid[nx][ny] == 1) {
                                        return step;
                                    } else if (grid[nx][ny] == 0) {
                                        grid[nx][ny] = 2;
                                        q.offer(new int[] {nx, ny});
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }

        return 0;
    }

    private void dfs(int x, int y) {
        grid[x][y] = 2;
        q.offer(new int[] {x, y});
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i], ny = y + d[i + 1];
            if (inArea(nx, ny) && grid[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}
