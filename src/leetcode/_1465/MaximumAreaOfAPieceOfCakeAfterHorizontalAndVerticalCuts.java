package leetcode._1465;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    int mod = (int) (1e9 + 7);
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hx = 0, vx = 0;
        int pre = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hn = horizontalCuts.length;
        int vn = verticalCuts.length;
        for (int hi : horizontalCuts) {
            int x = hi - pre;
            hx = Math.max(hx, x);
            pre = hi;
        }
        hx = Math.max(hx, h - pre);
        pre = 0;
        for (int vi : verticalCuts) {
            int x = vi - pre;
            vx = Math.max(vx, x);
            pre = vi;
        }
        vx = Math.max(vx, w - pre);
        long res = (long) hx * vx % mod;
        return (int) res;
    }
}
