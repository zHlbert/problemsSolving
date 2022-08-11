package leetcode._1419;

/**
 * https://leetcode.cn/problems/minimum-number-of-frogs-croaking/
 */
public class MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] cf = croakOfFrogs.toCharArray();
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int cnt = 0, res = 0;
        for (char ch : cf) {
            if (ch == 'c') {
                c++;
                cnt++;
                res = Math.max(res, cnt);
            } else if (ch == 'r') {
                r++;
            } else if (ch == 'o') {
                o++;
            } else if (ch == 'a') {
                a++;
            } else if (ch == 'k') {
                k++;
                cnt--;
            }
            if (!(c >= r && r >= o && o >= a && a >= k)) {
                return -1;
            }
        }
        return cnt == 0 ? res : -1;
    }
}
