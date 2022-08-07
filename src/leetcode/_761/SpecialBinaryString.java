package leetcode._761;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class SpecialBinaryString {
    /**
     * 递归
     * @param s
     * @return
     */
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        subs.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String sub : subs) {
            sb.append(sub);
        }
        return sb.toString();
    }
}
