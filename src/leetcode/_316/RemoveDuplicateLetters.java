package leetcode._316;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // s 中字符出现次数 - 已使用次数
        int[] cnt = new int[26];
        // 记录是否在栈内
        boolean[] vis = new boolean[26];


        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            cnt[ch - 'a']++;
        }

        for (char ch : chars) {
            // 栈中已有时丢弃
            if (!vis[ch - 'a']) {
                while (!deque.isEmpty() && deque.peekLast() > ch) {
                    char topCh = deque.peekLast();
                    if (cnt[topCh - 'a'] > 0) {
                        vis[topCh - 'a'] = false;
                        deque.pollLast();
                    } else {
                        // s 中该字符都已用过，不能再删除
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                deque.offerLast(ch);
            }
            cnt[ch - 'a']--;
        }
        StringBuilder resSb = new StringBuilder();
        while (!deque.isEmpty()) {
            resSb.append(deque.pollFirst());
        }
        return resSb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        String s = "cbacdcbc";
        System.out.println(rdl.removeDuplicateLetters(s));
    }
}
