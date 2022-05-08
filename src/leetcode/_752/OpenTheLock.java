package leetcode._752;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains(start)) {
            return -1;
        }
        Set<String> usedSet = new HashSet<>();

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        usedSet.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deadendSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < cur.length(); j++) {
                    String plusStr = compute(cur, j, true);
                    if (!usedSet.contains(plusStr)) {
                        queue.offer(plusStr);
                        usedSet.add(plusStr);
                    }
                    String minusStr = compute(cur, j, false);
                    if (!usedSet.contains(minusStr)) {
                        queue.offer(minusStr);
                        usedSet.add(minusStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String compute(String cur, int j, boolean forward) {
        char[] chars = cur.toCharArray();
//        StringBuilder sb = new StringBuilder(cur);
        char c = chars[j];
        char next = (char) ((c - '0' + 10 + (forward ? 1 : -1)) % 10 + '0');
//        char next;
//        if (forward && c == '9') {
//            next = '0';
//        } else if (!forward && c == '0') {
//            next = '9';
//        } else {
//            next = (char) (c + (forward ? 1 : -1));
//        }
//        sb.setCharAt(j, next);
        chars[j] = next;
        return new String(chars);
//        return sb.toString();
    }

    public static void main(String[] args) {
        OpenTheLock ol = new OpenTheLock();
//        String[] deadends = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String[] deadends = new String[] {"0000"};
        String target = "8888";
        System.out.println(ol.openLock(deadends, target));
//        StringBuilder sb = new StringBuilder(target);
//        char c = (char) (('9' - '0' + 1) % 10 + '0');
//        sb.setCharAt(3, c);
//        System.out.println(sb);
//        System.out.println((char) ('9' + 48));
        System.out.println((char) ('9' - 1));
    }
}
