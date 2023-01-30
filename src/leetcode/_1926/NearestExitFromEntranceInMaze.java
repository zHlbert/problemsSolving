package leetcode._1926;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};

    /**
     * bfs
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] d = new int[m][n];
        for (int[] dd : d) Arrays.fill(dd, -1);
        int[][] q = new int[10010][2];
        int hh = 0, tt = -1;
        q[++tt] = entrance;
        d[entrance[0]][entrance[1]] = 0;
        while (hh <= tt) {
            int[] pt = q[hh++];
            for (int i = 0; i < 4; i++) {
                int nx = pt[0] + dx[i], ny = pt[1] + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.' && d[nx][ny] == -1) {
                    d[nx][ny] = d[pt[0]][pt[1]] + 1;
                    q[++tt] = new int[] {nx, ny};
                    if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                        return d[nx][ny];
                    }
                }
            }
        }
        return -1;
    }

    public int nearestExit1(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] d = new int[m][n];
        for (int[] dd : d) Arrays.fill(dd, - 1);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(entrance);
        d[entrance[0]][entrance[1]] = 0;
        while (!q.isEmpty()) {
            int[] pt = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pt[0] + dx[i], ny = pt[1] + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.' && d[nx][ny] == -1) {
                    d[nx][ny] = d[pt[0]][pt[1]] + 1;
                    q.offer(new int[] {nx, ny});
                    if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1)
                        return d[nx][ny];
                }
            }
        }
        return -1;
    }
}
