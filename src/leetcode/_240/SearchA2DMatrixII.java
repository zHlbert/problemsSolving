package leetcode._240;

import utils.ArrayUtils;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int front = 0, end = n - 1;
        int mid, cur;
        while (front + 1 < end) {
            mid = (front + end) >> 1;
            cur = matrix[0][mid];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                end = mid;
            } else {
                front = mid;
            }
        }
        if (matrix[0][front] == target || matrix[0][end] == target) {
            return true;
        }
        int col = target > matrix[0][end] ? end : front;
        front = 0;
        end = m - 1;
        while (front + 1 < end) {
            mid = (front + end) >> 1;
            cur = matrix[mid][col];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                end = mid;
            } else {
                front = mid;
            }
        }

        System.out.println(col + " : " + front + " : " + end);
        return matrix[front][col] == target || matrix[end][col] == target;
    }

    public boolean searchMatrixRecur(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, m - 1, 0, n - 1);
    }

    private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart + 1 >= rowEnd && colStart + 1 >= colEnd) {
            return matrix[rowStart][colStart] == target || matrix[rowStart][colEnd] == target
                    || matrix[rowEnd][colStart] == target || matrix[rowEnd][colEnd] == target;
        }
        int rowMid = (rowStart + rowEnd) >> 1;
        int colMid = (colStart + colEnd) >> 1;
        if (matrix[rowMid][colMid] == target) {
            return true;
        } else if (matrix[rowMid][colMid] > target) {
            return search(matrix, target, rowStart, rowMid, colStart, colMid)
                    || search(matrix, target, rowStart, rowMid, colMid, colEnd)
                    || search(matrix, target, rowMid, rowEnd, colStart, colMid);
        }
        return search(matrix, target, rowStart, rowMid, colMid, colEnd)
                || search(matrix, target, rowMid, rowEnd, colStart, colMid)
                || search(matrix, target, rowMid, rowEnd, colMid, colEnd);
    }

    public boolean searchMatrixZigZag(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            int cur = matrix[x][y];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII sad = new SearchA2DMatrixII();
//        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = new int[][] {{1,4},{2,5}};
//        int[][] matrix = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] matrix = new int[][] {{1,3,5}};
        ArrayUtils.print2DArray(matrix);
        int target = -1;
        System.out.println(sad.searchMatrixZigZag(matrix, target));
    }
}
