package leetcode._467;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        dp[chars[0] - 'a'] = 1;
        // 在wraparound字符串中连续的长度
        int k = 1;
        for (int i = 1; i < n; i++) {
            int diff = chars[i] - chars[i - 1];
            // 当前字符是前面字符的下一个
            if (diff == 1 || diff == -25) {
                k++;
            } else {
                k = 1;
            }
            dp[chars[i] - 'a'] = Math.max(dp[chars[i] - 'a'], k);
        }

        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        UniqueSubstringsInWraparoundString us = new UniqueSubstringsInWraparoundString();
        String p = "zab";
        System.out.println(us.findSubstringInWraproundString(p));
    }
}
