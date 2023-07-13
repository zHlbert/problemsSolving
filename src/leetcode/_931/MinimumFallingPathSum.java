package leetcode._931;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] pathSum = new int[n][n];
        System.arraycopy(matrix[0], 0, pathSum[0], 0, n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                int minPre = pathSum[i][j];
                if (j > 0) {
                    minPre = Math.min(minPre, pathSum[i][j - 1]);
                }
                if (j < n - 1) {
                    minPre = Math.min(minPre, pathSum[i][j + 1]);
                }
                pathSum[i + 1][j] = minPre + matrix[i + 1][j];
            }
        }
        int res = 10000;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, pathSum[n - 1][i]);
        }
        return res;
    }

    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int[] pathSum = new int[n];
        System.arraycopy(matrix[0], 0, pathSum, 0, n);
        for (int i = 1; i < n; i++) {
            int[] tmp = new int[n];
            System.arraycopy(pathSum, 0, tmp, 0, n);
            for (int j = 0; j < n; j++) {
                int minPre = tmp[j];
                if (j > 0) minPre = Math.min(minPre, tmp[j - 1]);
                if (j < n - 1) minPre = Math.min(minPre, tmp[j + 1]);
                pathSum[j] = minPre + matrix[i][j];
            }
        }
        int res = 10000;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, pathSum[i]);
        }
        return res;
    }
}
