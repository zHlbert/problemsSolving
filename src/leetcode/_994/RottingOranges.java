package leetcode._994;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/rotting-oranges/
 */
public class RottingOranges {
    int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int total = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i,j});
                }
                if (grid[i][j] != 0) {
                    total++;
                }
            }
        }
        int count = queue.size();
        if (total == count) {
            return 0;
        }
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] di : dir) {
                    int nx = cur[0] + di[0];
                    int ny = cur[1] + di[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        count++;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
            minutes++;
        }
        return count == total ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = new int[][] {{0,2}};
        System.out.println(ro.orangesRotting(grid));
    }
}
