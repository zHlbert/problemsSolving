package leetcode._864;

import java.util.*;

/**
 *
 * 获取所有钥匙的最短路径
 * https://leetcode.cn/problems/shortest-path-to-get-all-keys/
 */
public class ShortestPathToGetAllKeys {
    int[][] dr = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * BFS + 状态压缩
     * @param grid
     * @return
     */
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        char[][] g = new char[m][n];
        for (int i = 0; i < m; i++) {
            g[i] = grid[i].toCharArray();
        }

        int sx = 0, sy = 0;
        Map<Character, Integer> key2Idx = new HashMap<>();
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(g[i][j])) {
                    if (!key2Idx.containsKey(g[i][j])) {
                        key2Idx.put(g[i][j], c++);
                    }
                }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sx, sy, 0});
        int[][][] dist = new int[m][n][1 << c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[sx][sy][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], mask = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i][0];
                int ny = y + dr[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] != '#') {
                    if (g[nx][ny] == '.' || g[nx][ny] == '@') {
                        if (dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            q.offer(new int[] {nx, ny, mask});
                        }
                    } else if (Character.isLowerCase(g[nx][ny])) {
                        int idx = key2Idx.get(g[nx][ny]);
                        if (dist[nx][ny][mask | (1 << idx)] == -1) {
                            dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
                            if ((mask | (1 << idx)) == (1 << c) - 1) {
                                return dist[nx][ny][mask | (1 << idx)];
                            }
                            q.offer(new int[] {nx, ny, mask | (1 << idx)});
                        }
                    } else {
                        int idx = key2Idx.get(Character.toLowerCase(g[nx][ny]));
                        if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            q.offer(new int[] {nx, ny, mask});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
