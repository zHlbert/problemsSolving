package leetcode._749;

import java.util.*;

/**
 * https://leetcode.cn/problems/contain-virus/
 */
public class ContainVirus {

    int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * BFS
     * @param isInfected
     * @return
     */
    public int containVirus(int[][] isInfected) {
        int res = 0;
        int m = isInfected.length, n = isInfected[0].length;
        while (true) {
            // 每个联通区域的邻居
            List<Set<Integer>> neighbors = new ArrayList<>();
            // 每个联通区域的防火墙数量
            List<Integer> walls = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[] {i, j});
                        Set<Integer> neighbor = new HashSet<>();
                        int idx = neighbors.size() + 1, wall = 0;
                        // 第 idx 区域的病毒标记为 -idx
                        isInfected[i][j] = -idx;
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dir[k][0], ny = cur[1] + dir[k][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        isInfected[nx][ny] = -idx;
                                        queue.offer(new int[] {nx, ny});
                                    } else if (isInfected[nx][ny] == 0) {
                                        wall++;
                                        neighbor.add(getHash(nx, ny));
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        walls.add(wall);
                    }
                }
            }

            if (neighbors.isEmpty()) {
                break;
            }

            // 找到邻居最多的联通区域下标 idx
            int idx = 0;
            for (int i = 1; i < neighbors.size(); i++) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }

            res += walls.get(idx);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] >= 0) {
                        continue;
                    }
                    if (isInfected[i][j] != -idx - 1) {
                        // 非idx区域还原为1
                        isInfected[i][j] = 1;
                    } else {
                        // 邻居最多的区域 值为2 表示无法再感染周围
                        isInfected[i][j] = 2;
                    }
                }
            }

            for (int i = 0; i < neighbors.size(); i++) {
                if (i == idx) {
                    continue;
                }
                Set<Integer> neighbor = neighbors.get(i);
                for (int xy : neighbor) {
                    // 还原邻居横纵坐标
                    int x = xy >> 16, y = xy & ((1 << 16) - 1);
                    isInfected[x][y] = 1;
                }
            }

            // 如果我们发现区域一共只有一块，那么这次防火墙建立后，不会再有病毒传播
            if (neighbors.size() == 1) {
                break;
            }
        }
        return res;
    }

    private int getHash(int nx, int ny) {
        return (nx << 16) ^ ny;
    }
}
