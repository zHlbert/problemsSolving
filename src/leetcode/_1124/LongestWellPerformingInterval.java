package leetcode._1124;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int s = 0;
        int res = 0;
        Map<Integer, Integer> sumIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (sumIdx.containsKey(s - 1)) {
                    res = Math.max(res, i - sumIdx.get(s - 1));
                }
            }
            if (!sumIdx.containsKey(s)) {
                sumIdx.put(s, i);
            }
        }

        return res;
    }

    // TODO: 2023/2/14 栈

    public static void main(String[] args) {
        LongestWellPerformingInterval lw = new LongestWellPerformingInterval();
        System.out.println(lw.longestWPI(new int[] {9,9,6,0,6,6,9}));
        System.out.println(lw.longestWPI(new int[] {6,6,6}));
        System.out.println(lw.longestWPI(new int[] {6,6,9}));
    }
}
