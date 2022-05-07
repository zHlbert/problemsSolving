package contest.leetcode20210619;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 「以扣会友」线下活动所在场地由若干主题空间与走廊组成，场地的地图记作由一维字符串型数组 grid，字符串中仅包含 "0"～"5" 这 6 个字符。地图上每一个字符代表面积为 1 的区域，其中 "0" 表示走廊，其他字符表示主题空间。相同且连续（连续指上、下、左、右四个方向连接）的字符组成同一个主题空间。
 *
 * 假如整个 grid 区域的外侧均为走廊。请问，不与走廊直接相邻的主题空间的最大面积是多少？如果不存在这样的空间请返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/YesdPw
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThemeSpaces {
    int m, n;
    int sum;
    boolean flag;
    Set<Character> nearPSet = new HashSet<>();
    public int largestArea(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        char[][] grids = new char[m][n];
        for (int i = 0; i < m; i++) {
            grids[i] = grid[i].toCharArray();
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grids[i][j];
                if (c >= '1' && c <= '5') {
                    flag = true;
                    sum = 0;
                    sumArea(grids, i, j, c);
                    if (flag) {
                        maxArea = Math.max(maxArea, sum);
                    }
                }
            }
        }
        return maxArea;
    }

    private void sumArea(char[][] grids, int x, int y, char cur) {
        if (!inArea(grids, x, y) || grids[x][y] == '0') {
            flag = false;
            return;
        }

        if (grids[x][y] != cur) {
            return;
        }

        grids[x][y] = '9';
        sum++;
        sumArea(grids, x + 1, y, cur);
        sumArea(grids, x, y + 1, cur);
        sumArea(grids, x - 1, y, cur);
        sumArea(grids, x, y - 1, cur);
    }

    private boolean inArea(char[][] grids, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
//        String[] grid = new String[] {
//                "11111100000", "21243101111", "21224101221", "11111101111"
//        };
        String[] grid = new String[] {
                "11111100000","21243101111","21224101221","11111101111"
        };
        ThemeSpaces t = new ThemeSpaces();
        System.out.println(t.largestArea(grid));
    }
}
