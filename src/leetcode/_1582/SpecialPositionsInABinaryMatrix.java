package leetcode._1582;

public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int res = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                boolean sp = true;
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (mat[i][k] == 1) {
                        sp = false;
                        break;
                    }
                }
                for (int k = 0; k < m; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (mat[k][j] == 1) {
                        sp = false;
                        break;
                    }
                }
                if (sp) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numSpecial1(int[][] mat) {
        int res = 0, m = mat.length, n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
