package leetcode._1234;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceTheSubstringForBalancedString {
//    Map<Character, Integer> cIdx = new HashMap<>();
    int n;
    int[] cnt;

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int balancedString(String s) {
//        cIdx.put('Q', 0);
//        cIdx.put('W', 1);
//        cIdx.put('E', 2);
//        cIdx.put('R', 3);
        char[] sc = s.toCharArray();
        n = sc.length;
        cnt = new int[26];
        for (char c : sc) {
            cnt[c - 'A']++;
        }
//        System.out.println(Arrays.toString(cnt));

        int res = n;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && larger()) {
                cnt[sc[j++] - 'A']--;
//                System.out.println(j + ", " + Arrays.toString(cnt));
            }
            if (!larger()) {
//                System.out.println(i + ", " + j);
                res = Math.min(res, j - i);
                if (res == 0) {
                    break;
                }
            }
            cnt[sc[i] - 'A']++;
        }
        return res;
    }

    private boolean larger() {
        return cnt['Q' - 'A'] > n / 4
                || cnt['W' - 'A'] > n / 4
                || cnt['E' - 'A'] > n / 4
                || cnt['R' - 'A'] > n / 4;
    }

    public static void main(String[] args) {
        ReplaceTheSubstringForBalancedString rs = new ReplaceTheSubstringForBalancedString();
//        System.out.println(rs.balancedString("QWER"));
//        System.out.println(rs.balancedString("QQWE"));
//        System.out.println(rs.balancedString("QQQW"));
        System.out.println(rs.balancedString("WQWRQQQW"));
    }
}
