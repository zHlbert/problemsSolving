package leetcode.offerII_114;

import java.util.*;

/**
 * https://leetcode.cn/problems/Jf1JuT/
 */
public class AlienOrder {
    // 拓扑排序
    public String alienOrder(String[] words) {
        Set<Character> chSet = new HashSet<>();
        int len = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chSet.add(c);
            }
        }
        int vNum = chSet.size();
        List<Character> vList = new ArrayList<>(chSet);

        // 边
        Set<Integer>[] edges = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            edges[i] = new HashSet<>();
        }
        // 入度
        int[] inDegrees = new int[26];

        // 生成边和入度
        for (int i = 0; i < len - 1; i++) {
            char[] pChars = words[i].toCharArray();
            char[] cChars = words[i + 1].toCharArray();
            int k = 0;
            int minLen = Math.min(pChars.length, cChars.length);
            for (; k < minLen; k++) {
                if (pChars[k] != cChars[k]) {
                    // 去重：不重复添加已有的边
                    if (!edges[pChars[k] - 'a'].contains(cChars[k] - 'a')) {
                        edges[pChars[k] - 'a'].add(cChars[k] - 'a');
                        inDegrees[cChars[k] - 'a']++;
                    }
                    break;
                }
            }
            if (k == minLen && k < pChars.length) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char v : vList) {
            if (inDegrees[v - 'a'] == 0) {
                queue.offer(v);
            }
        }

        int visited = 0;
        StringBuilder resSb = new StringBuilder();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            resSb.append(u);
            visited++;
            for (int v : edges[u - 'a']) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.offer((char) ('a' + v));
                }
            }
        }

        return visited == vNum ? resSb.toString() : "";
    }

    public static void main(String[] args) {
        AlienOrder ao = new AlienOrder();
//        String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
//        String[] words = new String[] {"z","x","z"};
//        String[] words = new String[] {"abc","ab"};
//        String[] words = new String[] {"ac","ab","zc","zb"};
        String[] words = new String[] {"wrt","wrf","er","ett","rftt","te"};
//        "ac","ab","zc","zb"
        System.out.println(ao.alienOrder(words));
    }
}
