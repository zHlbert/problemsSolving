package contest.leetcode20220430;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-77/problems/escape-the-spreading-fire/
 */
public class EscapeTheSpreadingFire {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] grid;
    int m, n;
    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int min = 0;
//        while(min < m + n - 2) {
//            if(!dfs(0, 0)) {
//                break;
//            }
//
//            min++;
//        }
//        if ()
        return 0;
    }

    public static void main(String[] args) {
        int i = (int) 10e9;
        System.out.println(i);
    }

    private void spreadFire() {
        List<int[]> fires = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fires.add(new int[] {i, j});
                }
            }
        }

        for (int[] fire : fires) {
            int r = fire[0];
            int c = fire[1];
            for (int i = 0; i < 4; i++) {
                r += dx[i];
                c += dy[i];
                if (grid[r][c] == 0) {
                    grid[r][c] = 1;
                }
            }
        }
    }
}
