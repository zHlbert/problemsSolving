package contest.leetcode20210815;

import java.util.Arrays;

/**
 * There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
 *
 * Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
 *
 * You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
 *
 * Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
 */
public class LastDayWhereYouCanStillCross {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int[][] matrix;
    boolean[][] walked;
    public int latestDayToCross(int row, int col, int[][] cells) {
        matrix = new int[row][col];
        walked = new boolean[row][col];
        for (int i = 0; i < cells.length; i++) {
            clearWalked();
            boolean through = false;
            matrix[cells[i][0] - 1][cells[i][1] - 1] = 1;
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    if (dfs(0, j)) {
                        through = true;
                        break;
                    }
                }
            }
            if (!through) {
                return i;
            }
        }
        return 0;
    }

    public void clearWalked() {
        for (boolean[] booleans : walked) {
            Arrays.fill(booleans, false);
        }
    }

    private boolean dfs(int i, int j) {
        if (i == matrix.length - 1) {
            return true;
        }
        walked[i][j] = true;
        boolean through = false;
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            if (nextX >= matrix.length || nextX < 0 || nextY >= matrix[0].length || nextY < 0) {
                continue;
            }
            if (matrix[nextX][nextY] == 1) {
                continue;
            }
            if (!walked[nextX][nextY]) {
                if (dfs(nextX, nextY)) {
                    through = true;
                    break;
                }
            }
        }
        return through;
    }

    public static void main(String[] args) {
        LastDayWhereYouCanStillCross l = new LastDayWhereYouCanStillCross();
//        int[][] cells = new int[][] {{1,1},{1,2},{2,1},{2,2}};
        int[][] cells = new int[][] {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
        System.out.println(l.latestDayToCross(3, 3, cells));
    }
}
