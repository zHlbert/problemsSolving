package leetcode._854;


import utils.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.cn/problems/k-similar-strings/
 */
public class KSimilarStrings {
    /**
     * https://leetcode.cn/problems/k-similar-strings/solution/xiang-si-du-wei-k-de-zi-fu-chuan-by-leet-8z10/
     * BFS
     * @param s1
     * @param s2
     * @return
     */
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(s1, 0));
        Set<String> visited = new HashSet<>();
        visited.add(s1);
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Pair<String, Integer> pair = queue.poll();
                String cur = pair.getKey();
                Integer pos = pair.getValue();
                if (cur.equals(s2)) {
                    return step;
                }
                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
                    pos++;
                }
                for (int j = pos + 1; j < n; j++) {
                    if (cur.charAt(j) == s2.charAt(j)) {
                        continue;
                    }
                    if (s2.charAt(pos) == cur.charAt(j)) {
                        String next = swap(cur, pos, j);
                        if (!visited.contains(next)) {
                            queue.offer(new Pair<>(next, pos + 1));
                            visited.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    public String swap(String str, int i, int j) {
        char[] sc = str.toCharArray();
        char tmp = sc[i];
        sc[i] = sc[j];
        sc[j] = tmp;
        return new String(sc);
    }
}
