package leetcode._587;

import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/erect-the-fence/
 */
public class ErectTheFence {
    // Andrew
    // https://leetcode-cn.com/problems/erect-the-fence/solution/an-zhuang-zha-lan-by-leetcode-solution-75s3/
    public int[][] outerTrees(int[][] trees) {
        int len = trees.length;
        if (len < 4) {
            return trees;
        }

        Arrays.sort(trees, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        Stack<Integer> hull = new Stack<>();
        hull.push(0);
        boolean[] used = new boolean[len];
        // 求出凸包的下半部分
        for (int i = 1; i < len; i++) {
            while (hull.size() > 1 && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.pop()] = false;
            }
            used[i] = true;
            hull.push(i);
        }

        // 求出凸包的上半部分
        int m = hull.size();
        for (int i = len - 2; i >= 0; i--) {
            if (!used[i]) {
                while (hull.size() > m && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                    used[hull.pop()] = false;
                }
                used[i] = true;
                hull.push(i);
            }
        }
        // hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0]
        hull.pop();

        int n = hull.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = trees[hull.pop()];
        }
        return res;
    }

    private int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    public static void main(String[] args) {
        ErectTheFence ef = new ErectTheFence();
        int[][] trees = new int[][] {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        ArrayUtils.print2DArray(ef.outerTrees(trees));
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.push(1);
//        deque.push(2);
//        deque.push(3);
//        Integer[] integers = deque.toArray(new Integer[0]);
//        System.out.println(Arrays.asList(integers));
    }
}
