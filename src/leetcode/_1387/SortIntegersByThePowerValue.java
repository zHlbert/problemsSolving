package leetcode._1387;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/sort-integers-by-the-power-value/
 */
public class SortIntegersByThePowerValue {
    Map<Integer, Integer> pw = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        for (int i = lo; i <= hi; i++) {
            getPower(i);
        }
//        System.out.println(pw);
        int[] q = new int[hi - lo + 1];
        for (int i = lo, j = 0; i <= hi; i++, j++) {
            q[j] = i;
            System.out.println(i + " : " + pw.get(i));
        }
        return kth(q, 0, q.length - 1, k);
    }

    /**
     * 快速选择
     * @param q
     * @param l
     * @param r
     * @param k
     * @return
     */
    private int kth(int[] q, int l, int r, int k) {
        if (l >= r) {
            return q[l];
        }
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (pw.get(q[i]) < pw.get(x) || pw.get(q[i]).equals(pw.get(x)) && q[i] < x);
            do {
                j--;
            } while (pw.get(q[j]) > pw.get(x) || pw.get(q[j]).equals(pw.get(x)) && q[j] > x);
            if (i < j) {
                int tmp = q[i];
                q[i] = q[j];
                q[j] = tmp;
            }
        }
        if ((j - l + 1) >= k) {
            return kth(q, l, j, k);
        } else {
            return kth(q, j + 1, r, k - (j - l + 1));
        }
    }

    /**
     * 记忆化搜索
     * @param i
     * @return
     */
    private int getPower(int i) {
        if (pw.containsKey(i)) {
            return pw.get(i);
        }
        int res;
        if (i == 1) {
            res = 1;
        } else if ((i & 1) == 0) {
            res = getPower(i >> 1) + 1;
        } else {
            res = getPower(3 * i + 1) + 1;
        }
        pw.put(i, res);
        return res;
    }

    /**
     * 排序
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth1(int lo, int hi, int k) {
        for (int i = lo; i <= hi; i++) {
            getPower(i);
        }
        int[][] q = new int[hi - lo + 1][2];
        for (int i = lo, j = 0; i <= hi; i++, j++) {
            q[j][0] = pw.get(i);
            q[j][1] = i;
        }
        Arrays.sort(q, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        return q[k - 1][1];
    }

    public static void main(String[] args) {
        SortIntegersByThePowerValue si = new SortIntegersByThePowerValue();
//        System.out.println(si.getKth(12, 15, 1));
//        System.out.println(si.getKth(12, 15, 2));
//        System.out.println(si.getKth(12, 15, 3));
//        System.out.println(si.getKth(12, 15, 4));
        System.out.println(si.getKth(1, 1000, 177));
//        System.out.println(si.getKth(7, 11, 4));
    }
}
