package contest.leetcode20220814;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstructSmallestNumberFromDIString {
//    public String smallestNumber(String pattern) {
//        int n = pattern.length();
//        int max = n + 1;
//        StringBuilder resSb = new StringBuilder();
//        if (pattern.indexOf('D') == -1) {
//            for (int i = 0; i < max; i++) {
//                resSb.append(i + 1);
//            }
//            return resSb.toString();
//        } else if (pattern.indexOf('I') == -1) {
//            for (int i = max - 1; i >= 0; i--) {
//                resSb.append(i + 1);
//            }
//            return resSb.toString();
//        }
//        char[] resCh = new char[n + 1];
//        char[] sc = pattern.toCharArray();
//        Set<Character> used = new HashSet<>();
//        int sm = 0;
//        for (int i = 0; i < n; i++) {
//            if (sc[i] == 'I') {
//                resCh[i] = '1';
//                used.add(resCh[i]);
//                sm = i;
//                break;
//            }
//        }
//        for (int i = sm - 1; i >= 0; i--) {
//            resCh[i] = (char) ('1' + (sm - i));
//            used.add(resCh[i]);
//        }
//        int lg = 0;
//        for (int i = n - 1; i >= sm + 1; i--) {
//            if (sc[i] == 'I') {
//                continue;
//            }
//            for (int j = i - 1; j >= sm; j--) {
//                if (sc[i] == 'I') {
//                    resCh[i + 1] = (char) ('0' + max);
//                    used.add(resCh[i + 1]);
//                    lg = i + 1;
//                    break;
//                }
//            }
//        }
//        for (int i = lg + 1; i < n + 1; i++) {
//            resCh[i] = (char) ('0' + max - (i - lg) - 1);
//            used.add(resCh[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            if (resCh[i] >= '1' && resCh[i] <= '0' + max) {
//                continue;
//            }
//            char ch = sc[i];
//            if (ch == 'I') {
//                for (char c = '1'; c <= '0' + max; c++) {
//                    if (!used.contains(c)) {
//                        resCh[i] = c;
//                        used.add(c);
//                        break;
//                    }
//                }
//            } else {
//                for (char c = (char) ('0' + max); c >= '1'; c--) {
//                    if (!used.contains(c)) {
//                        resCh[i] = c;
//                        used.add(c);
//                        break;
//                    }
//                }
//            }
//        }
//        if (resCh[n] < '1' || resCh[n] > '9') {
//            for (char c = '1'; c <= '0' + max; c++) {
//                if (!used.contains(c)) {
//                    resCh[n] = c;
//                    used.add(c);
//                    break;
//                }
//            }
//        }
//        return new String(resCh);
//    }

//    public String smallestNumber(String pattern) {
//        int n = pattern.length();
//        int max = n + 1;
//        StringBuilder resSb = new StringBuilder();
//        if (pattern.indexOf('D') == -1) {
//            for (int i = 0; i < max; i++) {
//                resSb.append(i + 1);
//            }
//            return resSb.toString();
//        } else if (pattern.indexOf('I') == -1) {
//            for (int i = max - 1; i >= 0; i--) {
//                resSb.append(i + 1);
//            }
//            return resSb.toString();
//        }
//        char[] resCh = new char[n + 1];
//        Arrays.fill(resCh, 'x');
//        Set<Character> used = new HashSet<>();
//        char[] sc = pattern.toCharArray();
//        char cur = '1';
//        int end = 0;
//        for (int i = 0; i < n; i++) {
//            if (sc[i] == 'D') {
//                continue;
//            }
//            resCh[i] = cur;
//            used.add(resCh[i]);
//            cur = (char) (cur + 1);
//            end = i;
//        }
//
//        for (int j = end + 1; j <= n; j++) {
//            resCh[j] = (char) ('1' + max - (j - end));
//            used.add(resCh[j]);
//        }
//        for (int j = end - 1; j >= 0; j--) {
//            if (resCh[j] == 'x') {
//                for (char c = '1'; c <= '9'; c++) {
//                    if (!used.contains(c)) {
//                        resCh[j] = c;
//                        used.add(resCh[j]);
//                    }
//                }
//            }
//        }
//        return new String(resCh);
//    }
    String res = "";
    boolean[] visited;
    int n;
    char[] pc;

    public String smallestNumber(String pattern) {
        n = pattern.length();
        visited = new boolean[10];
        pc = pattern.toCharArray();
        for (int i = 1; i <= n + 1; i++) {
            visited[i] = true;
            backtrack(0, i, new StringBuilder(String.valueOf(i)));
            visited[i] = false;
            if (!res.isEmpty()) {
                break;
            }
        }
        return res;
    }

    private void backtrack(int idx, int pre, StringBuilder sb) {
        if (!res.isEmpty()) {
            return;
        }
        if (idx == n) {
            res = sb.toString();
            return;
        }
        boolean incr = (pc[idx] == 'I');
        for (int i = (incr ? pre + 1 : 1); i <= (incr ? n + 1 : pre - 1); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i);
                backtrack(idx + 1, i, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ConstructSmallestNumberFromDIString cs = new ConstructSmallestNumberFromDIString();
//        String s = "IIIDIDDD";
        String s = "DDDIII";
        System.out.println(cs.smallestNumber(s));
    }
}
