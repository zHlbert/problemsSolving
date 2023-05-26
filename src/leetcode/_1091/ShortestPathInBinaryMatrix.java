package leetcode._1091;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    static int[] dx = new int[] {1,1,0,-1,-1,-1,0,1};
    static int[] dy = new int[] {0,1,1,1,0,-1,-1,-1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        boolean[][] used = new boolean[n][n];
        int res = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        used[0][0] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] pt = q.poll();
                int x = pt[0], y = pt[1];
                if (x == n - 1 && y == n - 1) return res + 1;
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || used[nx][ny] || grid[nx][ny] != 0) continue;
                    q.offer(new int[] {nx, ny});
                    used[nx][ny] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
