package contest.leetcode20220703;

import utils.ArrayUtils;
import utils.LinkedListUtils;
import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode cur = head;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int numEle = m * n;
        int[][] res = new int[m][n];
        List<Integer> listVals = new ArrayList<>();
        while (cur != null) {
            listVals.add(cur.val);
            cur = cur.next;
        }

        int j = 0;
        int val = j < listVals.size() ? listVals.get(j++) : -1;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                res[top][i] = val;
                numEle--;
                val = j < listVals.size() ? listVals.get(j++) : -1;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                res[i][right] = val;
                numEle--;
                val = j < listVals.size() ? listVals.get(j++) : -1;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                res[bottom][i] = val;
                numEle--;
                val = j < listVals.size() ? listVals.get(j++) : -1;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                res[i][left] = val;
                numEle--;
                val = j < listVals.size() ? listVals.get(j++) : -1;
            }
            left++;
        }
        return res;
    }

    public int[][] spiralMatrix1(int m, int n, ListNode head) {
        int[] dx = new int[] {0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        ListNode cur = head;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < m * n && cur != null; i++) {
            res[x][y] = cur.val;
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || res[nx][ny] != -1) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixIV sm = new SpiralMatrixIV();
        int m = 3, n = 5;
        ListNode list = LinkedListUtils.initializeLinkedListNoExtra(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0, 3, 8, 9});
//        int m = 1, n = 4;
//        ListNode list = LinkedListUtils.initializeLinkedListNoExtra(new int[]{0,1,2,3,4});
        ArrayUtils.print2DArray(sm.spiralMatrix(m, n, list));
    }
}
