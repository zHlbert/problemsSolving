package leetcode._1072;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {
    /**
     * 哈希
     * https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/solution/an-lie-fan-zhuan-de-dao-zui-da-zhi-deng-teeig/
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                // row[0] 为 1 时翻转该行元素
                arr[j] = (char) ('0' + (row[j] ^ row[0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (int cnt : map.values()) {
            res = Math.max(res, cnt);
        }
        return res;
    }
}
