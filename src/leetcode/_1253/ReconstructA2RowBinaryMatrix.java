package leetcode._1253;

import java.util.ArrayList;
import java.util.List;

public class ReconstructA2RowBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> up = new ArrayList<>();
        List<Integer> lo = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int s : colsum) {
            if (s == 0) {
                up.add(0);
                lo.add(0);
            } else if (s == 2) {
                up.add(1);
                lo.add(1);
                upper--;
                lower--;
            } else {
                if (upper >= lower) {
                    up.add(1);
                    upper--;
                    lo.add(0);
                } else {
                    lo.add(1);
                    lower--;
                    up.add(0);
                }
            }
            if (upper < 0 || lower < 0) {
                return res;
            }
        }
        if (upper > 0 || lower > 0) {
            return res;
        }
        res.add(up);
        res.add(lo);
        return res;
    }
}
