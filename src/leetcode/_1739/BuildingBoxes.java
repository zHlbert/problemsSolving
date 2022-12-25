package leetcode._1739;

/**
 * 放置盒子
 * https://leetcode.cn/problems/building-boxes/
 */
public class BuildingBoxes {
    long g(int i) {
        return (long) i * (i + 1) * (i + 2) / 6;
    }

    /**
     * 数学 解方程
     * https://leetcode.cn/problems/building-boxes/solution/fang-zhi-he-zi-by-leetcode-solution-7ah2/
     * @param n
     * @return
     */
    public int minimumBoxes(int n) {
        int i = (int) Math.pow(6.0 * n, 1.0 / 3);
        if (g(i) < n) i++;
        n -= g(i - 1);
        int j = (int) Math.ceil((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        return (i - 1) * i / 2 + j;
    }
}
