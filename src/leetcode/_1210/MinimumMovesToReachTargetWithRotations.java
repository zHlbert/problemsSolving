package leetcode._1210;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MinimumMovesToReachTargetWithRotations {
    int[][] dxs = new int[][] {{0,0},{1,1},{1,0},{-1,0}};
    int[][] dys = new int[][] {{1,1},{0,0},{-1,0},{1,0}};

    /**
     * bfs
     * @param grid
     * @return
     */
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        // q<[x, y]> 表示头节点和尾节点的横纵坐标
        q.offer(new int[] {1, 0});
        // d[i][j] i 表示头节点的横纵坐标，j 表示蛇的方向 0: 左右 1: 上下
        int[][] d = new int[n * n][2];
        for (int[] dd : d)
            Arrays.fill(dd, -1);
        d[1][0] = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int head = pos[0], tail = pos[1];
            int dir = (head - tail) / n;
            int hx = head / n, hy = head % n;
            int tx = tail / n, ty = tail % n;
            if (hx == n - 1 && hy == n - 1 && tx == n - 1 && ty == n - 2)
                return d[head][0];
//            System.out.println("pos: " + Arrays.toString(new int[] {hx, hy}) + ", " + Arrays.toString(new int[] {tx, ty}));
            for (int i = 0; i < 4; i++) {
                int[] dx = dxs[i], dy = dys[i];
                int nhx = hx + dx[0], nhy = hy + dy[0], ntx = tx + dx[1], nty = ty + dy[1];
                if (!(nhx >= 0 && nhx < n && nhy >= 0 && nhy < n)) continue;
                if (i == 2 && (hx != tx || grid[nhx][nhy] != 0 || grid[nhx][nhy + 1] != 0))
                    continue;
                if (i == 3 && (hy != ty || grid[nhx][nhy] != 0 || grid[nhx + 1][nhy] != 0))
                    continue;
                int nh = nhx * n + nhy, nt = ntx * n + nty;
                int nDir = (nh - nt) / n;
//                System.out.println(Arrays.toString(new int[] {nhx, nhy}) + ", " + Arrays.toString(new int[] {ntx, nty}));
                if (grid[nhx][nhy] == 0 && grid[ntx][nty] == 0 && d[nh][nDir] == -1) {
                    q.offer(new int[] {nh, nt});
                    d[nh][nDir] = d[head][dir] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumMovesToReachTargetWithRotations mm = new MinimumMovesToReachTargetWithRotations();
        int[][] grid = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(mm.minimumMoves(grid));
    }
}
