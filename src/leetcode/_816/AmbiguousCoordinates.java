package leetcode._816;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/ambiguous-coordinates/
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i < n; i++) {
            List<String> l = numList(s.substring(0, i));
            if (l.isEmpty()) {
                continue;
            }
            List<String> r = numList(s.substring(i));
            if (r.isEmpty()) {
                continue;
            }
            for (String s1 : l) {
                for (String s2 : r) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return res;
    }

    private List<String> numList(String s) {
        int n = s.length();
        List<String> nums = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            nums.add(s);
        }
        for (int i = 1; i < n; i++) {
            if (i != 1 && s.charAt(0) == '0' || s.charAt(n - 1) == '0') {
                continue;
            }
            nums.add(s.substring(0, i) + "." + s.substring(i));
        }
        return nums;
    }
}
