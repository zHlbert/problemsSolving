package leetcode._131;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        Deque<String> queue = new LinkedList<>();
        backtrack(s, queue, 0);
        return res;
    }

    private void backtrack(String s, Deque<String> queue, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(queue));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (isPalindrome(subStr)) {
                queue.offerLast(subStr);
                backtrack(s, queue, i + 1);
                queue.pollLast();
            }
        }
    }

    private boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String s = "a";
        System.out.println(pp.partition(s));
    }
}
