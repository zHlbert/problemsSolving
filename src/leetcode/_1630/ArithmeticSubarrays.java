package leetcode._1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    /**
     * 排序
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int st = l[i], ed = r[i];
            int[] tmp = new int[ed - st + 1];
            for (int j = st, k = 0; j <= ed; j++, k++) {
                tmp[k] = nums[j];
            }
            Arrays.sort(tmp);
            int d = tmp[1] - tmp[0];
            boolean arithmetic = true;
            for (int j = 2; j < tmp.length; j++) {
                if (tmp[j] - tmp[j - 1] != d) {
                    arithmetic = false;
                    break;
                }
            }
            res.add(arithmetic);
        }
        return res;
    }
}
