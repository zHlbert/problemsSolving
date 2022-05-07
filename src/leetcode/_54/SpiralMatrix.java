package leetcode._54;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    boolean[][] arrived;
    List<Integer> res;
    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    int d = dx.length;
    int m, n;
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        arrived = new boolean[m][];
        for (int i = 0; i < m; i++) {
            arrived[i] = new boolean[n];
        }
        res = new ArrayList<>(m * n);
        int x = 0, y = 0;
        dfs(matrix, x, y, 0);
        return res;
    }

    /**
     *
     * @param matrix
     * @param x
     * @param y
     * @param di 上次行进的方向
     */
    private void dfs(int[][] matrix, int x, int y, int di) {
        if (arrived[x][y]) {
            return;
        }
        res.add(matrix[x][y]);
        arrived[x][y] = true;
        for (int i = 0; i < d; i++) {
            int nextD = (di + i) % d;
            int nextX = x + dx[nextD];
            int nextY = y + dy[nextD];
            if (nextX >= m || nextX < 0 || nextY >= n || nextY < 0) {
                continue;
            }
            if (!arrived[nextX][nextY]) {
                dfs(matrix, nextX, nextY, nextD);
            }
        }
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(numEle);
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                res.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                res.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                res.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                res.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(s.spiralOrder1(matrix));
    }
}
