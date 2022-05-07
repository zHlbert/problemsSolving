package leetcode._79;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSearch {
    int[] d1 = new int[] {1, 0, -1, 0};
    int[] d2 = new int[] {0, 1, 0, -1};
    char[][] board;
    int m;
    int n;
    String word;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtracking1(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtracking1(int row, int col, int curr) {
        if (board[row][col] != word.charAt(curr)) {
            return false;
        }
        if (curr == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        boolean existed = false;
        for (int k = 0; k < 4; k++) {
            int nextI = row + d1[k];
            int nextJ = col + d2[k];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                if (!visited[nextI][nextJ]) {
                    if (backtracking1(nextI, nextJ, curr + 1)) {
                        existed = true;
                        break;
                    }
                }
            }
        }
        visited[row][col] = false;
        return existed;
    }
}
