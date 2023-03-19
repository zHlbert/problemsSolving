package leetcode._1625;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations {
    /**
     * BFS
     *
     * @param s
     * @param a
     * @param b
     * @return
     */
    public String findLexSmallestString(String s, int a, int b) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        Set<String> visited = new HashSet<>(q);
        String res = s;
        int n = s.length();
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            char[] sc = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                sc[i] = (char) ((sc[i] - '0' + a) % 10 + '0');
            }
            String tmp = new String(sc);
            if (visited.add(tmp)) q.offer(tmp);
            cur = cur.substring(n - b) + cur.substring(0, n - b);
            if (visited.add(cur)) q.offer(cur);
        }
        return res;
    }
}
