package leetcode._850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/rectangle-area-ii/
 */
public class RectangleAreaII {

    private static final int mod = (int) (1e9 + 7);
    /**
     * 计算几何 扫描线
     * 将整个图形垂直切分 从左到右扫描 每个横坐标区间（len）内纵坐标之差的并集长度(height)，累加所有区间的 len * height
     * @param rectangles
     * @return
     */
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        // 所有横坐标
        int[] xs = new int[2 * n];
        for (int i = 0; i < n; i++) {
            xs[2 * i] = rectangles[i][0];
            xs[2 * i + 1] = rectangles[i][2];
        }
        Arrays.sort(xs);
        long res = 0;
        for (int i = 1; i < 2 * n; i++) {
            int a = xs[i - 1], b = xs[i], len = b - a;
            if (len == 0) {
                continue;
            }
            List<int[]> lines = new ArrayList<>();
            for (int[] rec : rectangles) {
                // 包含 [a, b] 的 矩形的纵坐标集合
                if (rec[0] <= a && rec[2] >= b) {
                    lines.add(new int[] {rec[1], rec[3]});
                }
            }
            lines.sort((p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);
            long height = 0, l = -1, r = -1;
            // 合并横坐标[a, b]之间的 所有纵坐标长度
            for (int[] line : lines) {
                if (line[0] > r) {
                    height += r - l;
                    l = line[0];
                    r = line[1];
                } else if (line[1] > r){
                    r = line[1];
                }
            }
            height += r - l;
            res += len * height;
            res %= mod;
        }
        return (int) res;
    }
}
