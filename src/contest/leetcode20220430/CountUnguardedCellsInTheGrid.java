package contest.leetcode20220430;

import utils.ArrayUtils;

/**
 * Count Unguarded Cells in the Grid
 */
public class CountUnguardedCellsInTheGrid {
    int[][] guards;
    int[][] walls;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count = 0;
        int total = m * n;
        // 0 未访问 1 已访问 2 卫兵 3 墙
        int[][] visited = new int[m][n];
        if (guards.length + walls.length == total) {
            return 0;
        }

        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = 3;
        }

        for (int[] guard : guards) {
            visited[guard[0]][guard[1]] = 2;
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            for (int i = 0; i < 4; i++) {
                int curR = row + dx[i];
                int curC = col + dy[i];
                while (curR >= 0 && curR < m && curC >= 0 && curC < n) {
                    int v = visited[curR][curC];
                    if (v == 2 || v == 3) {
                        break;
                    }
                    if (v == 0) {
                        count++;
                        visited[curR][curC] = 1;
                    }
                    curR = curR + dx[i];
                    curC = curC + dy[i];
                }
            }
        }
        return total - guards.length - walls.length - count;
    }

    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid cuc = new CountUnguardedCellsInTheGrid();
        int m = 3;
        int n = 3;
//        int[][] guards = new int[][] {{0,0},{1,1},{2,3}};
//        int[][] walls = new int[][] {{0,1},{2,2},{1,4}};
        int[][] guards = new int[][] {{1,1}};
        int[][] walls = new int[][] {{0,1},{1,0},{2,1},{1,2}};
        System.out.println(cuc.countUnguarded(m, n, guards, walls));
    }
}
